package org.jetbrains.kstats.query

import org.jetbrains.kstats.cron.withTransaction
import org.jetbrains.kstats.db
import org.jetbrains.kstats.model.ChangesCache
import org.jetbrains.kstats.model.TeamCityChangeRelation
import org.jetbrains.ktor.routing.Route
import org.jetbrains.squash.definition.Name
import org.jetbrains.squash.results.get
import java.time.LocalDate
import java.time.OffsetTime
import java.time.format.DateTimeFormatter


object StatisticsPerDay {
    data class QueryPerDayResult(val date: LocalDate, val all: Int, val kotlin: Int)

    private object SQLForQuery {
        val vcs_root_tcid by lazy { TeamCityChangeRelation.vcsRootTcId.toSQL() }
        val author by lazy { ChangesCache.author.name.toSQL() }
        val changed_files by lazy { ChangesCache.files.name.toSQL() }
        val kotlin_files by lazy { ChangesCache.kotlinFiles.name.toSQL() }
        val date by lazy { ChangesCache.date.name.toSQL() }
        val changesCache by lazy { ChangesCache.tableName.toSQL() }
    }

    fun commits(range: ClosedRange<LocalDate>) = withTransaction {
        SQLForQuery.run {
            val (start, end) = range.formatForDB()
            val sql = """
                SELECT
                    FORMATDATETIME($date, 'yyyy-MM-ddZ') AS DATEM,
                    SUM($changed_files > 0),
                    SUM($kotlin_files > 0)
                FROM $changesCache
                WHERE $date > '$start' AND $date <= '$end'
                GROUP BY DATEM
                ORDER BY DATEM
            """.trimIndent()

            return@run executeStatement(sql).map {
                QueryPerDayResult(parseDBDate(it[0]), it[1], it[2])
            }.toList()
        }
    }


    fun commiters(range: ClosedRange<LocalDate>) = withTransaction {
        SQLForQuery.run {
            val (start, end) = range.formatForDB()
            //TODO Add enough functional to Squash, to rewrite this expression with DSL
            val sql = """
                SELECT
                  DATUM,
                  SUM(CHANGES_PER_AUTHOR.CHANGES > 0),
                  SUM(CHANGES_PER_AUTHOR.CHANGES_WITH_KOTLIN > 0)
                FROM (SELECT
                        $author,
                        SUM($changed_files > 0) AS CHANGES,
                        SUM($kotlin_files > 0)  AS CHANGES_WITH_KOTLIN,
                        FORMATDATETIME($date, 'yyyy-MM-ddZ') AS DATUM
                      FROM $changesCache
                      WHERE
                        $author IS NOT NULL
                        AND $date > '$start'
                        AND $date <= '$end'
                      GROUP BY $author, DATUM
                     ) AS CHANGES_PER_AUTHOR
                GROUP BY DATUM
                ORDER BY DATUM
            """.trimIndent()

            return@run executeStatement(sql).map {
                QueryPerDayResult(parseDBDate(it[0]), it[1], it[2])
            }.toList()
        }
    }

    fun vcsRoots(range: ClosedRange<LocalDate>) = withTransaction {
        SQLForQuery.run {
            val (start, end) = range.formatForDB()
            val sql = """
                SELECT
                  DATUM,
                  SUM(CHANGES_PER_AUTHOR.CHANGES > 0),
                  SUM(CHANGES_PER_AUTHOR.CHANGES_WITH_KOTLIN > 0)
                FROM (SELECT
                        SUM($changed_files > 0)  AS CHANGES,
                        SUM($kotlin_files > 0)   AS CHANGES_WITH_KOTLIN,
                        FORMATDATETIME("date", 'yyyy-MM-ddZ') AS DATUM
                      FROM CHANGESCACHE
                        JOIN ${TeamCityChangeRelation.toSQL()} ON ${ChangesCache.id.toSQL()} = ${TeamCityChangeRelation.id.toSQL()}
                      WHERE
                        $vcs_root_tcid IS NOT NULL
                        AND $date > '$start'
                        AND $date <= '$end'
                      GROUP BY $vcs_root_tcid, DATUM
                     ) AS CHANGES_PER_AUTHOR
                GROUP BY DATUM
                ORDER BY DATUM
            """.trimIndent()

            return@run executeStatement(sql).map {
                QueryPerDayResult(parseDBDate(it[0]), it[1], it[2])
            }.toList()
        }
    }
}

