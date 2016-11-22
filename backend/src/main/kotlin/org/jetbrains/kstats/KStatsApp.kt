package org.jetbrains.kstats

import com.github.salomonbrys.kotson.jsonArray
import com.github.salomonbrys.kotson.jsonObject
import com.github.salomonbrys.kotson.toJsonArray
import com.google.gson.Gson
import com.google.gson.stream.JsonWriter
import org.jetbrains.kstats.cron.Cron
import org.jetbrains.kstats.model.ChangeAuthors
import org.jetbrains.kstats.model.ChangesCache
import org.jetbrains.kstats.query.kotlinCommitsVsAllPerDay
import org.jetbrains.ktor.application.*
import org.jetbrains.ktor.content.resolveClasspathResource
import org.jetbrains.ktor.content.resolveClasspathWithPath
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.logging.CallLogging
import org.jetbrains.ktor.response.respondText
import org.jetbrains.ktor.routing.Route
import org.jetbrains.ktor.routing.Routing
import org.jetbrains.ktor.routing.get
import org.jetbrains.ktor.routing.route
import org.jetbrains.squash.dialects.h2.H2Connection
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun Route.staticFolder(base: String) {
    route(base) {
        get("*") {
            val resource = call.resolveClasspathResource(base, "/web$base")
            if (resource != null) {
                call.respond(resource)
            }
        }
    }
}


fun Route.index() {
    get("/") {
        call.respond(call.resolveClasspathWithPath("/web", "index.html")!!)
    }
}

val gson = Gson()

fun Route.api() {
    route("/api") {
        get("kotlinCommitsVsAll") {
            val now = LocalDate.now()
            val jsonArray = kotlinCommitsVsAllPerDay(now.minusDays(7)..now).map { (date, all, kotlin) ->
                jsonObject("date" to date.format(DateTimeFormatter.ISO_DATE), "all" to all, "kotlin" to kotlin)
            }.toJsonArray()
            call.respondText(ContentType.Application.Json, gson.toJson(jsonArray))
        }
    }
}

val db = H2Connection.create("jdbc:h2:file:./db")

class KStatsApp : AutoCloseable {
    override fun close() {
        Cron.stop()
    }

    fun Application.install() {
        Cron.start()

        install(DefaultHeaders)
        install(CallLogging)
        install(Routing) {
            staticFolder("/css")
            staticFolder("/js")
            staticFolder("/js/lib")
            staticFolder("/fonts")
            staticFolder("/fonts/roboto")
            index()
            api()
        }
    }


}