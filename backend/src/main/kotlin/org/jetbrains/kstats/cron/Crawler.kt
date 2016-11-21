package org.jetbrains.kstats.cron

import com.github.salomonbrys.kotson.get
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import kotlinx.support.jdk7.use
import org.jetbrains.kstats.db
import org.jetbrains.kstats.model.ChangesCache
import org.jetbrains.kstats.model.ChangesCache.changeId
import org.jetbrains.kstats.model.ChangesCache.id
import org.jetbrains.kstats.rest.REST
import org.jetbrains.squash.connection.Transaction
import org.jetbrains.squash.query.orderBy
import org.jetbrains.squash.query.select
import org.jetbrains.squash.results.get
import org.jetbrains.squash.statements.insertInto
import org.jetbrains.squash.statements.values
import java.text.SimpleDateFormat
import java.time.LocalDateTime

class Crawler(val client: REST) {


    lateinit var transaction: Transaction

    fun doWork() {
        transaction = db.createTransaction()
        queryChanges()
        transaction.commit()
    }


    fun recordChange(change: JsonElement) {
        with(transaction) {
            insertInto(ChangesCache).values {
                it[changeId] = change["id"].asLong

                it[date] = LocalDateTime.parse(change["date"].asString, client.dateFormatter)
            }
        }
    }

    fun queryChanges() {
        with(transaction) {
            val latestIndexedChange = ChangesCache.select { changeId }.orderBy { id }.execute().firstOrNull()?.get(changeId) ?: -1
            val changes = client.changesSinceChange(latestIndexedChange)["change"].asJsonArray
            if (changes.size() == 0) {
                return
            }
            changes.forEach(::println)
            changes.forEach(this@Crawler::recordChange)
        }
    }
}

