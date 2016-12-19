package org.jetbrains.kstats

import com.natpryce.konfig.*
import com.natpryce.konfig.ConfigurationProperties.Companion.systemProperties
import java.io.File


fun optionalFile(f: File): Configuration =
        if (f.exists())
            ConfigurationProperties.fromFile(f)
        else
            ConfigurationMap() //Empty config

val config = systemProperties() overriding
        EnvironmentVariables() overriding
        optionalFile(File("data/kstats.properties")) overriding
        ConfigurationProperties.fromResource("default.properties")

object Config {
    object teamcity : PropertyGroup() {
        val url by stringType
        val guest by booleanType
        val user by stringType
        val password by stringType
        val additional_certificates by stringType
        val start_tcid by longType
    }

    object server : PropertyGroup() {
        val host by stringType
        val port by intType
    }

}
