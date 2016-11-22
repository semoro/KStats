package org.jetbrains.kstats.model

import org.jetbrains.kstats.cron.withThreadLocalTransaction
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
    val tcid = long("tcid").uniqueIndex() // TeamCity author id TODO: Separate relation table

    fun create(dto: AuthorDTO) = withThreadLocalTransaction {
        dto.id = insertInto(ChangeAuthors).values {
            it[tcid] = dto.tcid
            it[displayName] = dto.displayName
            it[username] = dto.username
        }.fetch(id).execute()
    }

    fun createIfNotExist(dto: AuthorDTO) = withThreadLocalTransaction {
        select { id }.where { tcid eq dto.tcid }.execute().singleOrNull()?.let {
            dto.id = it[id]
        } ?: create(dto)
    }
}

data class AuthorDTO(var displayName: String,
                     var username: String,
                     var tcid: Long,
                     var id: Int? = null)