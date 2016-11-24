package org.jetbrains.kstats.query

import org.jetbrains.kstats.cron.withTransaction
import org.jetbrains.kstats.model.ChangesCache
import org.jetbrains.squash.results.get
import java.time.LocalDate


fun kotlinCommitAuthorsPerDay(range: ClosedRange<LocalDate>) = withTransaction {
    val author = ChangesCache.author.name.toSQL()
    val changed_files = ChangesCache.files.name.toSQL()
    val kotlin_files = ChangesCache.kotlinFiles.name.toSQL()
    val date = ChangesCache.date.name.toSQL()
    val changesCache = ChangesCache.tableName.toSQL()

    val start = range.start.plusDays(1).formatForDB()
    val end = range.endInclusive.plusDays(1).formatForDB()

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
    return@withTransaction executeStatement(sql).map {
        QueryPerDayResult(parseDBDate(it[0]), it[1], it[2])
    }.toList()
}