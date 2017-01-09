package org.jetbrains.kstats.model

import org.jetbrains.kstats.cron.withTransaction
import org.jetbrains.kstats.model.TeamCityAuthorRelation.addRelation
import org.jetbrains.kstats.model.TeamCityAuthorRelation.findIdByTCID
import org.jetbrains.squash.definition.*
import org.jetbrains.squash.expressions.eq
import org.jetbrains.squash.query.select
import org.jetbrains.squash.query.where
import org.jetbrains.squash.results.get
import org.jetbrains.squash.statements.fetch
import org.jetbrains.squash.statements.insertInto
import org.jetbrains.squash.statements.values

object ChangeAuthors : TableDefinition() {
    val id = integer("id").primaryKey().autoIncrement()
    val displayName = text("display_name")
    val username = text("username")

    fun create(dto: AuthorDTO) = withTransaction {
        dto.id = insertInto(ChangeAuthors).values {
            it[displayName] = dto.displayName
            it[username] = dto.username
        }.fetch(id).execute()
    }

    fun createIfNotExist(dto: AuthorDTO, _tcid: Long) = withTransaction {
        findIdByTCID(_tcid)?.let {
            dto.id = it
        } ?: create(dto).apply {
            addRelation(dto.id!!, _tcid)
        }
    }
}

object TeamCityAuthorRelation : TableDefinition() {
    val id = reference(ChangeAuthors.id)
    val tcid = long("tcid") //TeamCity Author ID

    init {
        primaryKey(id, tcid)
    }

    fun findIdByTCID(_tcid: Long) = withTransaction {
        return@withTransaction select { id }.where { tcid eq _tcid }.execute().singleOrNull()?.let { it[id] }
    }

    fun addRelation(_id: Int, _tcid: Long) = withTransaction {
        insertInto(TeamCityAuthorRelation).values {
            it[id] = _id
            it[tcid] = _tcid
        }.execute()
    }
}

data class AuthorDTO(var displayName: String,
                     var username: String,
                     var id: Int? = null)