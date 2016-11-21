package org.jetbrains.kstats.cron

import org.jetbrains.kstats.rest.REST
import org.junit.Test

class CrawlerTest {
    @Test
    fun name() {
        val rest = REST("https://teamcity.jetbrains.com")

        val crawler = Crawler(rest)
        crawler.doWork()
    }
}
