package org.jetbrains.kstats

import com.github.salomonbrys.kotson.jsonObject
import com.github.salomonbrys.kotson.registerTypeAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.jetbrains.kstats.cron.Cron
import org.jetbrains.kstats.model.DBInitializer
import org.jetbrains.kstats.query.StatisticsPerDay
import org.jetbrains.kstats.query.formatForJS
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.ApplicationCallPipeline
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.content.TextContent
import org.jetbrains.ktor.content.resolveClasspathResource
import org.jetbrains.ktor.content.resolveClasspathWithPath
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.http.HeaderValue
import org.jetbrains.ktor.logging.CallLogging
import org.jetbrains.ktor.request.acceptItems
import org.jetbrains.ktor.routing.Route
import org.jetbrains.ktor.routing.get
import org.jetbrains.ktor.routing.route
import org.jetbrains.ktor.routing.routing
import org.jetbrains.ktor.transform.transform
import org.jetbrains.squash.dialects.h2.H2Connection
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

fun buildGson(): Gson {
    val builder = GsonBuilder()
    builder.registerTypeAdapter<StatisticsPerDay.QueryPerDayResult> {
        serialize {
            val (date, all, kotlin) = it.src
            return@serialize jsonObject("date" to date.formatForJS(), "all" to all, "kotlin" to kotlin)
        }
    }
    return builder.create()
}

val gson = buildGson()

data class Json(val data: Any)

fun Route.api() {

    route("/api") {

        intercept(ApplicationCallPipeline.Infrastructure) { call ->
            if (HeaderValue("application/json") in call.request.acceptItems()) {
                call.transform.register<Json> { (data) ->
                    TextContent(ContentType.Application.Json, gson.toJson(data))
                }
            }
        }

        route("statistics") {
            route("per_day") {
                get("commits") {
                    val days = min(subject.parameters["days"]?.toLong() ?: 7, 31)
                    val now = LocalDate.now()
                    call.respond(Json(StatisticsPerDay.commits(now.minusDays(days)..now)))
                }
                get("commiters") {
                    val days = min(subject.parameters["days"]?.toLong() ?: 7, 31)
                    val now = LocalDate.now()
                    call.respond(Json(StatisticsPerDay.commiters(now.minusDays(days)..now)))
                }
                get("vcsRoots") {
                    val days = min(subject.parameters["days"]?.toLong() ?: 7, 31)
                    val now = LocalDate.now()
                    call.respond(Json(StatisticsPerDay.vcsRoots(now.minusDays(days)..now)))
                }
            }
        }
    }
}

val db = H2Connection.create("jdbc:h2:file:./data/db")


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

        routing {
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

