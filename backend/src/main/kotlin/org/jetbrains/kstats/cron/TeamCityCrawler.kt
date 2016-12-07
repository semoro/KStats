package org.jetbrains.kstats.cron

import com.github.salomonbrys.kotson.*
import com.google.gson.JsonElement
import org.jetbrains.kstats.model.*
import org.jetbrains.kstats.model.TeamCityChangeRelation.findChangeID
import org.jetbrains.kstats.model.TeamCityChangeRelation.findChangeIDs
import org.jetbrains.kstats.model.TeamCityChangeRelation.findLatestChangeTCID

import org.jetbrains.kstats.rest.REST
import java.time.LocalDateTime
import kotlin.system.measureTimeMillis

class TeamCityCrawler(val client: REST, val startTCID: Long) {

    var processedChanges = 0
    var uniqueChanges = 0
    fun doWork() {
        try {
            println("TeamCity crawler started")
            val time = measureTimeMillis {
                queryChanges()
            }
            println("TeamCity crawler processed $processedChanges changes, $uniqueChanges unique changes in ${time / 1000}s")

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    val skippedChangeTypes = listOf("deleted", "moved")

    val processedChangesSet = mutableSetOf<Long>()

    fun processShortChange(change: JsonElement) {
        processedChanges++
        val tcid = change["id"].long

        if (tcid in processedChangesSet) return //No more non-unique tcid's

        val version = change["version"].string

        val duplicateCandidates = findChangeIDs(version)

        duplicateCandidates.singleOrNull()?.let { duplicate ->
            return TeamCityChangeRelation.addRelation(duplicate, tcid)
        }

        val detailedChange = client.detailedChangeById(tcid).obj
        println(detailedChange)
        val vcsId = detailedChange["vcsRootInstance"]["id"].long
        if (duplicateCandidates.isNotEmpty()) {
            findChangeID(version, vcsId)?.let { duplicate ->
                return TeamCityChangeRelation.addRelation(duplicate, tcid)
            }
        }

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
            TeamCityChangeRelation.addUniqueChange(this.id!!, tcid, version, vcsId)
        }
        uniqueChanges++
    }

    fun processChanges(changesResponse: JsonElement) {
        val changes = changesResponse.obj.get("change")?.array
        if (changes == null || changes.size() == 0) {
            return
        }

        withThreadLocalTransaction {
            changes.forEach(this@TeamCityCrawler::processShortChange)
            commit()
        }

        changesResponse.obj.get("nextHref").nullString?.let {
            processChanges(client.nextHref(it))
        }
    }

    fun queryChanges() {
        processChanges(client.changesSinceChange(startTCID))
    }
}

