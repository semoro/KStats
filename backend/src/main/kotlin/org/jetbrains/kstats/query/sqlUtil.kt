package org.jetbrains.kstats.query

import org.jetbrains.kstats.db
import org.jetbrains.squash.definition.Name

fun Name.toSQL() = db.dialect.nameSQL(this)
