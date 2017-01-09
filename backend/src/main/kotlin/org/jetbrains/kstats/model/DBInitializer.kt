package org.jetbrains.kstats.model

import org.jetbrains.kstats.cron.withTransaction
import org.jetbrains.kstats.db
import kotlin.concurrent.thread


object DBInitializer {
    private val tables = listOf(ChangeAuthors, TeamCityAuthorRelation, ChangesCache, TeamCityChangeRelation)

    fun initializeDataBase() {
        withTransaction {
            databaseSchema().create(tables)
            commit()
        }

        Runtime.getRuntime().addShutdownHook(thread(start = false, block = db::close))
    }
}

