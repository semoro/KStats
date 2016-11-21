package org.jetbrains.kstats.rest

import com.github.salomonbrys.kotson.get
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class RESTTest {

    lateinit var client: REST

    @Before
    fun setUp() {
        client = REST("http://localhost:8111")
        client.auth("kstats", "12345678")
    }

    @Test
    fun testAllProjects() {
        client.auth("kstats", "12345678")
        val projects = client.projects()
        assertEquals("/app/rest/projects", projects["href"].asString)
    }
}