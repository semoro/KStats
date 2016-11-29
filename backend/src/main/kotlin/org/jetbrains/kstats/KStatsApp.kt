package org.jetbrains.kstats

import com.github.salomonbrys.kotson.jsonObject
import com.github.salomonbrys.kotson.toJsonArray
import com.google.gson.Gson
import org.jetbrains.kstats.cron.Cron
import org.jetbrains.kstats.model.DBInitializer
import org.jetbrains.kstats.query.StatisticsPerDay
import org.jetbrains.kstats.query.formatForJS
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.application.install
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
import java.lang.Math.max
import java.lang.Math.min
import java.time.LocalDate

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
        route("statistics") {
            route("per_day") {
                get("commits") {
                    val days = min(subject.parameters["days"]!!.toLong(), 31)
                    val now = LocalDate.now()
                    val jsonArray = StatisticsPerDay.commits(now.minusDays(days)..now).map { (date, all, kotlin) ->
                        jsonObject("date" to date.formatForJS(), "all" to all, "kotlin" to kotlin)
                    }.toJsonArray()
                    call.respondText(ContentType.Application.Json, gson.toJson(jsonArray))
                }
                get("commiters") {
                    val days = min(subject.parameters["days"]!!.toLong(), 31)
                    val now = LocalDate.now()
                    val jsonArray = StatisticsPerDay.commiters(now.minusDays(days)..now).map { (date, all, kotlin) ->
                        jsonObject("date" to date.formatForJS(), "all" to all, "kotlin" to kotlin)
                    }.toJsonArray()
                    call.respondText(ContentType.Application.Json, gson.toJson(jsonArray))
                }
            }
        }
    }
}

val db = H2Connection.create("jdbc:h2:file:./db")


class KStatsApp : AutoCloseable {
    override fun close() {
        Cron.stop()
        db.close()
    }

    fun Application.install() {
        DBInitializer.initializeDataBase()
        Cron.start()

        install(DefaultHeaders)
        install(CallLogging)
        install(Routing) {
            staticFolder("/css")
            staticFolder("/img")
            staticFolder("/js")
            staticFolder("/js/lib")
            staticFolder("/fonts")
            staticFolder("/fonts/roboto")
            index()
            api()
        }
    }


}