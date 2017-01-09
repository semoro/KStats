package org.jetbrains.kstats.cron

import kotlinx.support.jdk7.use
import org.jetbrains.kstats.db
import org.jetbrains.squash.connection.Transaction


fun <R> withTransaction(statement: Transaction.() -> R): R = db.createTransaction().use(statement)
