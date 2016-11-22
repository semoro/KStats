package org.jetbrains.kstats.query

import java.time.LocalDate

fun ClosedRange<LocalDate>.daysSequence() = generateSequence(start) { it.plusDays(1) }.takeWhile { it <= endInclusive }