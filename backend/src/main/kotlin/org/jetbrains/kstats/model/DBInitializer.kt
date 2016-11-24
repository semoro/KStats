package org.jetbrains.kstats.model

import org.jetbrains.kstats.cron.withTransaction


object DBInitializer {
    private val tables = listOf(ChangeAuthors, TeamCityAuthorRelation, ChangesCache, TeamCityChangeRelation)

    fun initializeDataBase() {
        withTransaction {
            databaseSchema().create(tables)
            commit()
        }
    }
}

