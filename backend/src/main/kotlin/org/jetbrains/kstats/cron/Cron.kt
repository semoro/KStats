package org.jetbrains.kstats.cron


import mu.KotlinLogging.logger
import org.jetbrains.kstats.Config.teamcity
import org.jetbrains.kstats.config
import org.jetbrains.kstats.model.TeamCityChangeRelation
import org.jetbrains.kstats.rest.REST
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

object Cron {
    val executor = Executors.newSingleThreadScheduledExecutor()
    lateinit var rest: REST
    lateinit var defaultTask: ScheduledFuture<*>
    val log = logger("Cron")

    fun auth() {
        if (config[teamcity.guest])
            rest.guestAuth()
        else
            rest.auth(config[teamcity.user], config[teamcity.password])
    }

    fun start() {
        log.info("Starting")
        //db.monitor.after { sqlStatement, any -> println(sqlStatement) }
        val certificates = config.getOrElse(teamcity.additional_certificates, "").split(":").filterNot(String::isBlank).map(::File)
        rest = REST(config[teamcity.url], certificates)
        auth()

        defaultTask = executor.scheduleWithFixedDelay(this::collectChanges, 0, 1, TimeUnit.MINUTES)

        executor.scheduleWithFixedDelay({
            withTransaction {
                executeStatement("SHUTDOWN COMPACT")
            }
        }, 5, 5, TimeUnit.MINUTES)
    }

    fun stop() {
        defaultTask.cancel(true)
        executor.shutdownNow()
    }

    fun collectChanges() {
        auth()
        log.info("Collecting changes")

        val startTCID = TeamCityChangeRelation.findLatestChangeTCID() ?: config[teamcity.start_tcid]
        val crawler = TeamCityCrawler(rest, startTCID)
        crawler.doWork()
    }
}