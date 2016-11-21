package org.jetbrains.kstats.model

import org.jetbrains.squash.definition.*

object ChangeAuthors : TableDefinition() {
    val id = integer("id").autoIncrement()
    val displayName = text("displayName")
    val tcid = integer("tcid")
}