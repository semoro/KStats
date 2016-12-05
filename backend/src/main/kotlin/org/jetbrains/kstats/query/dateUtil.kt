package org.jetbrains.kstats.query

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneId.systemDefault
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.*

private val utc = ZoneId.of("UTC").normalized()

fun LocalDate.toUTC(): ZonedDateTime {
    return this.atStartOfDay(systemDefault()).withZoneSameInstant(utc)
}

fun LocalDate.formatForDB(): String {
    return atStartOfDay(systemDefault()).format(ISO_OFFSET_DATE_TIME)
}

fun LocalDate.formatForJS(): String {
    return toUTC().format(ISO_DATE_TIME)
}

private val DB_DATE_RESPONSE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-ddZ")

fun parseDBDate(str: String): LocalDate {
    return LocalDate.parse(str, DB_DATE_RESPONSE_FORMAT)
}

fun ClosedRange<LocalDate>.formatForDB() = start.plusDays(1).formatForDB() to
        endInclusive.plusDays(1).formatForDB()