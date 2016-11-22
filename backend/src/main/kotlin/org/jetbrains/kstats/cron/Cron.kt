package org.jetbrains.kstats.cron

import kotlinx.support.jdk7.use
import org.jetbrains.kstats.db
import org.jetbrains.kstats.model.ChangeAuthors
import org.jetbrains.kstats.model.ChangesCache
import org.jetbrains.kstats.model.TeamCityChangeRelation
import org.jetbrains.kstats.rest.REST
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

object Cron {
    val executor = Executors.newSingleThreadScheduledExecutor()


    fun initializeDataBase() {
        withTransaction {
            databaseSchema().create(listOf(ChangeAuthors, ChangesCache, TeamCityChangeRelation))
            commit()
        }
    }

    fun start() {
        db.monitor.after { sqlStatement, any -> println(sqlStatement) }
        initializeDataBase()

        executor.scheduleAtFixedRate(this::collectChanges, 0, 1, TimeUnit.MINUTES)

    }

    fun stop() {
        executor.shutdownNow()
        db.close()
    }

    fun collectChanges() {
        println("Collecting changes")
        val rest = REST("https://teamcity.jetbrains.com")
        rest.guestAuth() //TODO: REST auth
        val crawler = TeamCityCrawler(rest)
        crawler.doWork()
    }
}