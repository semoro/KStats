package org.jetbrains.kstats.rest

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import cookies.NonPersistentCookieJar
import okhttp3.*
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

class REST(val serverUrl: String) {

    private val client: OkHttpClient

    init {
        val builder = OkHttpClient.Builder()
        builder.cookieJar(NonPersistentCookieJar())
        client = builder.build()
    }

    private val jsonParser = JsonParser()

    private fun rb(url: String): Request.Builder {
        return Request.Builder().url("$serverUrl$url").header("Accept", "application/json")
    }

    fun auth(user: String, password: String) {
        val request = rb("/httpAuth/app/rest/builds").get().header("Authorization", Credentials.basic(user, password)).build()
        val response = client.newCall(request).execute()
        when (response.code()) {
            401 -> throw ExceptionInInitializerError("Invalid user/password")
            else -> {
                if (!response.isSuccessful)
                    throw ExceptionInInitializerError("Could not connect")
            }
        }
    }

    fun guestAuth() {
        val request = rb("/guestAuth/app/rest/builds").get().build()
        val response = client.newCall(request).execute()
        when (response.code()) {
            401 -> throw ExceptionInInitializerError("No guest access")
            else -> {
                if (!response.isSuccessful)
                    throw ExceptionInInitializerError("Could not connect")
            }
        }
    }


    fun getJson(path: String): JsonElement {
        val request = rb(path).build()
        val response = client.newCall(request).execute()
        if (response.isSuccessful)
            return jsonParser.parse(response.body().charStream())
        else
            throw RuntimeException("Accessing to $path returned error code: ${response.code()}\n with message: ${response.body().string()}")
    }

    fun projects() = getJson("/app/rest/projects")
    fun changesSinceChange(id: Long) = getJson("/app/rest/changes?locator=sinceChange:$id,count:100")
    fun detailedChangeById(id: Long) = getJson("/app/rest/changes/id:$id")

    val dateFormatter = DateTimeFormatterBuilder().appendPattern("yyyyMMdd").appendLiteral("T").appendPattern("HHmmss").appendOffset("+HHMM", "GMT").toFormatter()
}