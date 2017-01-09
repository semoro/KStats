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
import kotlin.concurrent.thread

object Cron {
    val executor = Executors.newSingleThreadScheduledExecutor()
    lateinit var rest: REST
    lateinit var defaultTask: ScheduledFuture<*>
    var additionalTasks = mutableListOf<ScheduledFuture<*>>()

    val log = logger("Cron")

    fun auth() {
        if (config[teamcity.guest])
            rest.guestAuth()
        else
            rest.auth(config[teamcity.user], config[teamcity.password])
    }

    fun start() {
        log.info("Starting")
        val certificates = config.getOrElse(teamcity.additional_certificates, "").split(":").filterNot(String::isBlank).map(::File)
        rest = REST(config[teamcity.url], certificates)
        auth()

        additionalTasks.add(executor.scheduleWithFixedDelay({ compactDatabase(false) }, 0, 35, TimeUnit.MINUTES))
        additionalTasks.add(executor.scheduleWithFixedDelay({ compactDatabase(true) }, 1, 2, TimeUnit.HOURS))

        defaultTask = executor.scheduleWithFixedDelay(this::collectChanges, 0, 1, TimeUnit.MINUTES)


        Runtime.getRuntime().addShutdownHook(thread(start = false, block = this::stop))
    }

    fun stop() {
        additionalTasks.forEach { it.cancel(false) }
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

    fun compactDatabase(defrag: Boolean) {
        val action = if (defrag) "DEFRAG" else "COMPACT"
        log.debug { "Compacting database, action: $action" }
        withTransaction {
            executeStatement("SHUTDOWN $action")
        }
    }
}