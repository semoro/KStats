package org.jetbrains.kstats

import org.jetbrains.kstats.model.ChangeAuthors
import org.jetbrains.kstats.model.ChangesCache
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.application.module
import org.jetbrains.ktor.content.resolveClasspathResource
import org.jetbrains.ktor.content.resolveClasspathWithPath
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.logging.CallLogging
import org.jetbrains.ktor.routing.Route
import org.jetbrains.ktor.routing.Routing
import org.jetbrains.ktor.routing.get
import org.jetbrains.ktor.routing.route
import org.jetbrains.squash.dialects.h2.H2Connection

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

val db = H2Connection.create("jdbc:h2:file:./db")

class KStatsApp {

    fun Application.install() {
        with(db.createTransaction()){
            databaseSchema().create(listOf(ChangesCache, ChangeAuthors))
            commit()
        }


        install(DefaultHeaders)
        install(CallLogging)
        install(Routing) {
            staticFolder("/css")
            staticFolder("/js")
            staticFolder("/js/lib")
            staticFolder("/fonts")
            staticFolder("/fonts/roboto")
            index()
        }
    }

}