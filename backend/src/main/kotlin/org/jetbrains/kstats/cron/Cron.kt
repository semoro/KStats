package org.jetbrains.kstats.cron


import org.jetbrains.kstats.Config.teamcity
import org.jetbrains.kstats.config
import org.jetbrains.kstats.rest.REST
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

object Cron {
    val executor = Executors.newSingleThreadScheduledExecutor()
    lateinit var rest: REST
    lateinit var defaultTask: ScheduledFuture<*>

    fun start() {
        rest = REST(config[teamcity.url])

        if (config[teamcity.guest])
            rest.guestAuth()
        else
            rest.auth(config[teamcity.user], config[teamcity.password])

        defaultTask = executor.scheduleWithFixedDelay(this::collectChanges, 0, 1, TimeUnit.MINUTES)
    }

    fun stop() {
        defaultTask.cancel(true)
        executor.shutdownNow()
    }

    fun collectChanges() {
        println("Collecting changes")
        val crawler = TeamCityCrawler(rest)
        crawler.doWork()
    }
}