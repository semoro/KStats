package org.jetbrains.kstats.rest

import com.google.gson.JsonElement
import com.google.gson.JsonParser
import cookies.NonPersistentCookieJar
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Request
import ssl.TrustUtil
import java.io.File
import java.time.format.DateTimeFormatterBuilder
import java.util.concurrent.TimeUnit
import javax.net.ssl.X509TrustManager


class REST(val serverUrl: String, certificates: List<File>) {

    private val client: OkHttpClient

    init {
        val builder = OkHttpClient.Builder()
        if (certificates.isNotEmpty()) {
            val trustUtil = TrustUtil(certificates.toTypedArray())
            trustUtil.init()
            builder.sslSocketFactory(trustUtil.sslContext.socketFactory, trustUtil.trustManagers[0] as X509TrustManager)
        }
        builder.readTimeout(1, TimeUnit.MINUTES)
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
        response.use {
            when (response.code()) {
                401 -> throw ExceptionInInitializerError("Invalid user/password")
                else -> {
                    if (!response.isSuccessful)
                        throw ExceptionInInitializerError("Could not connect")
                }
            }
        }
    }

    fun guestAuth() {
        val request = rb("/guestAuth/app/rest/builds").get().build()
        val response = client.newCall(request).execute()
        response.use {
            when (response.code()) {
                401 -> throw ExceptionInInitializerError("No guest access")
                else -> {
                    if (!response.isSuccessful)
                        throw ExceptionInInitializerError("Could not connect")
                }
            }
        }
    }


    fun getJson(path: String): JsonElement {
        val request = rb(path).build()
        val response = client.newCall(request).execute()
        return response.use {
            if (response.isSuccessful)
                jsonParser.parse(response.body().charStream())
            else
                throw RuntimeException("Accessing to $path returned error code: ${response.code()}\n with message: ${response.body().string()}")
        }
    }

    fun projects() = getJson("/app/rest/projects")
    fun changesSinceChange(id: Long) = getJson("/app/rest/changes?locator=sinceChange:$id,count:100")
    fun detailedChangeById(id: Long) = getJson("/app/rest/changes/$id")

    fun nextHref(next: String) = getJson(next)

    val dateFormatter = DateTimeFormatterBuilder().appendPattern("yyyyMMdd").appendLiteral("T").appendPattern("HHmmss").appendOffset("+HHMM", "GMT").toFormatter()
}