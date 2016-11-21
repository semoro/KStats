package org.jetbrains.kstats.model

import org.jetbrains.squash.definition.*

object ChangesCache : TableDefinition() {
    val id = integer("id").primaryKey().autoIncrement()
    val changeId = long("changeId")
    val author = reference(ChangeAuthors.tcid, "author_tcid").nullable()
    val date = datetime("date")
}