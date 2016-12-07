package org.jetbrains.kstats.model

import org.jetbrains.kstats.cron.withThreadLocalTransaction
import org.jetbrains.squash.definition.*
import org.jetbrains.squash.expressions.and
import org.jetbrains.squash.expressions.eq
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

}

object TeamCityChangeRelation : TableDefinition() {
    val id = reference(ChangesCache.id)
    val tcid = long("tcid").uniqueIndex() //TeamCity Change ID
    val commitVersion = varchar("version", 128).nullable()
    val vcsRootTcId = long("vcs_root_tcid").nullable().index()

    fun addUniqueChange(_id: Int, _tcid: Long, _commitVersion: String, _vcsRootTcId: Long) = withThreadLocalTransaction {
        insertInto(TeamCityChangeRelation).values {
            it[id] = _id
            it[tcid] = _tcid
            it[commitVersion] = _commitVersion
            it[vcsRootTcId] = _vcsRootTcId
        }.execute()
    }

    fun addRelation(_id: Int, _tcid: Long) = withThreadLocalTransaction {
        insertInto(TeamCityChangeRelation).values {
            it[id] = _id
            it[tcid] = _tcid
        }.execute()
    }

    fun findChangeIDs(_commitVersion: String) = withThreadLocalTransaction {
        return@withThreadLocalTransaction select { id }.where {
            commitVersion eq _commitVersion
        }.execute().map { it[id] }.toList()
    }

    fun findChangeID(_commitVersion: String, _vcsRootTcId: Long) = withThreadLocalTransaction {
        return@withThreadLocalTransaction select { id }.where {
            commitVersion eq _commitVersion and (vcsRootTcId eq _vcsRootTcId)
        }.execute().singleOrNull()?.get(id)
    }

    fun findLatestChangeTCID() = withThreadLocalTransaction {
        TeamCityChangeRelation.select { tcid }.orderBy(ascending = false) { tcid }.execute().firstOrNull()?.get(tcid)
    }
}

data class ChangeDTO(var author: AuthorDTO?,
                     var date: LocalDateTime,
                     var files: Int,
                     var kotlinFiles: Int,
                     var id: Int? = null)