package org.jetbrains.kstats.model

import org.jetbrains.kstats.cron.withThreadLocalTransaction
import org.jetbrains.kstats.cron.withTransaction
import org.jetbrains.squash.definition.*
import org.jetbrains.squash.expressions.*
import org.jetbrains.squash.query.orderBy
import org.jetbrains.squash.query.select
import org.jetbrains.squash.query.where
import org.jetbrains.squash.results.get
import org.jetbrains.squash.statements.fetch
import org.jetbrains.squash.statements.insertInto
import org.jetbrains.squash.statements.values
import java.time.LocalDateTime

object ChangesCache : TableDefinition() {
    val id = integer("id").primaryKey().autoIncrement()

    val author = reference(ChangeAuthors.id, "author_id").nullable()
    val date = datetime("date")

    val files = integer("changed_files")
    val kotlinFiles = integer("kotlin_files")

    fun create(change: ChangeDTO) = withThreadLocalTransaction {
        change.id = insertInto(ChangesCache).values {
            it[date] = change.date
            it[author] = change.author?.id
            it[files] = change.files
            it[kotlinFiles] = change.kotlinFiles
        }.fetch(id).execute()
    }

    fun countChangesInTimeRange(range: ClosedRange<LocalDateTime>) = withTransaction {
        return@withTransaction select { id.count() }
                .where { (date gteq range.start) and (date lteq literal(range.endInclusive)) }
                .execute().first().get<Int>(0)
    }

    fun countKotlinChangesInTimeRange(range: ClosedRange<LocalDateTime>) = withTransaction {
        return@withTransaction select { id.count() }
                .where {
                    (date gteq range.start) and
                            (date lteq literal(range.endInclusive)) and
                            (kotlinFiles gt 0)
                }
                .execute().first().get<Int>(0)
    }

}

object TeamCityChangeRelation : TableDefinition() {
    val id = reference(ChangesCache.id)
    val tcid = long("tcid") //TeamCity Change ID

    init {
        primaryKey(id, tcid)
    }

    fun addRelation(_id: Int, _tcid: Long) = withThreadLocalTransaction {
        insertInto(TeamCityChangeRelation).values {
            it[id] = _id
            it[tcid] = _tcid
        }.execute()
    }

    fun findLatestChangeTCID() = withThreadLocalTransaction {
        TeamCityChangeRelation.select { tcid }.orderBy(ascending = false) { tcid }.execute().firstOrNull()?.get(tcid) ?: -1
    }
}

data class ChangeDTO(var author: AuthorDTO?,
                     var date: LocalDateTime,
                     var files: Int,
                     var kotlinFiles: Int,
                     var id: Int? = null)