package org.jetbrains.kstats.query

import org.jetbrains.kstats.cron.withTransaction
import org.jetbrains.kstats.db
import org.jetbrains.kstats.model.ChangesCache
import org.jetbrains.squash.definition.Name
import org.jetbrains.squash.results.get
import java.time.LocalDate
import java.time.OffsetTime
import java.time.format.DateTimeFormatter

data class QueryPerDayResult(val date: LocalDate, val all: Int, val kotlin: Int)

fun Name.toSQL() = db.dialect.nameSQL(this)


fun kotlinCommitsVsAllPerDay(range: ClosedRange<LocalDate>) = withTransaction {
    val start = range.start.plusDays(1).formatForDB()
    val end = range.endInclusive.plusDays(1).formatForDB()
    val date = ChangesCache.date.name.toSQL()
    return@withTransaction executeStatement("""
                SELECT
                  FORMATDATETIME($date, 'yyyy-MM-ddZ') AS DATEM,
                  SUM(${ChangesCache.files.name.toSQL()} > 0),
                  SUM(${ChangesCache.kotlinFiles.name.toSQL()} > 0)
                FROM ${ChangesCache.tableName.toSQL()}
                WHERE $date > '$start' AND $date <= '$end'
                GROUP BY DATEM
                ORDER BY DATEM""".trimIndent())
            .map { QueryPerDayResult(parseDBDate(it[0]), it[1], it[2]) }
            .toList()
}
