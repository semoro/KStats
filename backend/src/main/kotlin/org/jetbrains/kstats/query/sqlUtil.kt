@file:Suppress("NOTHING_TO_INLINE")

package org.jetbrains.kstats.query

import org.jetbrains.kstats.db
import org.jetbrains.squash.definition.Column
import org.jetbrains.squash.definition.Name
import org.jetbrains.squash.definition.TableDefinition

inline fun Name.toSQL() = db.dialect.nameSQL(this)

inline fun TableDefinition.toSQL() = tableName.toSQL()

inline fun Column<*>.toSQL() = name.toSQL()