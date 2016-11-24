package org.jetbrains.kstats.cron

import com.github.salomonbrys.kotson.*
import com.google.gson.JsonElement
import org.jetbrains.kstats.model.*
import org.jetbrains.kstats.model.TeamCityChangeRelation.findLatestChangeTCID

import org.jetbrains.kstats.rest.REST
import java.time.LocalDateTime
import kotlin.system.measureTimeMillis

class TeamCityCrawler(val client: REST) {

    var processedChanges = 0
    fun doWork() {
        try {
            println("TeamCity crawler started")
            val time = measureTimeMillis {
                withThreadLocalTransaction {
                queryChanges()
                commit()
                }
            }
            println("TeamCity crawler processed $processedChanges in ${time / 1000}s")

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    val skippedChangeTypes = listOf("deleted", "moved")

    fun processShortChange(change: JsonElement) {
        val tcid = change["id"].long
        val detailedChange = client.detailedChangeById(tcid).obj
        println(detailedChange)

        val date = LocalDateTime.parse(change["date"].string, client.dateFormatter)
        val author = detailedChange.get("user")?.let { user ->
            user.obj.get("id")?.let { id ->
                AuthorDTO(user.obj.get("name").nullString ?: user["username"].string, user["username"].string)
                        .apply { ChangeAuthors.createIfNotExist(this, id.long) }
            }
        }
        val files = detailedChange["files"].obj
        val fileCount = files["count"].int
        val kotlinFileCount = files["file"].array.asSequence().filter { it["changeType"].string !in skippedChangeTypes }
                .map { it["file"].string }.filter { it.endsWith(".kt", true) || it.endsWith(".kts", true) }.count()
        ChangeDTO(author, date, fileCount, kotlinFileCount).apply {
            ChangesCache.create(this)
            TeamCityChangeRelation.addRelation(this.id!!, tcid)
        }
    }

    fun processChanges(changesResponse: JsonElement) {
        val changes = changesResponse.obj.get("change")?.array
        if (changes == null || changes.size() == 0) {
            return
        }
        changes.forEach(this::processShortChange)
        changesResponse.obj.get("nextHref").nullString?.let {
            processChanges(client.nextHref(it))
        }
    }

    fun queryChanges() {
        processChanges(client.changesSinceChange(findLatestChangeTCID()))
    }
}

