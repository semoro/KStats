package org.jetbrains.kstats

import org.jetbrains.kstats.Config.server
import org.jetbrains.ktor.application.applicationEnvironment
import org.jetbrains.ktor.host.applicationHostConfig
import org.jetbrains.ktor.host.connector
import org.jetbrains.ktor.jetty.embeddedJettyServer

fun main(args: Array<String>) {
    val config = applicationHostConfig {
        connector {
            host = config[server.host]
            port = config[server.port]
        }
    }

    val environment = applicationEnvironment {}

    val app = KStatsApp()
    app.apply {
        embeddedJettyServer(config, environment) {
            install()
        }.start(true)
    }
}