package org.jetbrains.kstats.query

import org.jetbrains.kstats.model.ChangesCache
import java.time.LocalDate

data class CommitsPerDayResult(val date: LocalDate, val all: Int, val kotlin: Int)

fun kotlinCommitsVsAllPerDay(range: ClosedRange<LocalDate>) =
        range.daysSequence()
                .map { it to it.atStartOfDay()..it.atStartOfDay().plusDays(1) }
                .map { (date, dayRange) ->
                    CommitsPerDayResult(date,
                            ChangesCache.countChangesInTimeRange(dayRange),
                            ChangesCache.countKotlinChangesInTimeRange(dayRange))
                }.toList()