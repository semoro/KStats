package org.jetbrains.kstats.cron

import kotlinx.support.jdk7.use
import org.jetbrains.kstats.db
import org.jetbrains.squash.connection.Transaction


fun <R> withTransaction(statement: Transaction.() -> R): R = db.createTransaction().use(statement)

private val threadLocalTransaction = ThreadLocal.withInitial { db.createTransaction() }

fun <R> withThreadLocalTransaction(statement: Transaction.() -> R): R {
    val transaction = threadLocalTransaction.get()
    return transaction.run(statement)
}

