package org.jetbrains.kstats

import com.natpryce.konfig.*
import com.natpryce.konfig.ConfigurationProperties.Companion.systemProperties
import java.io.File


val config = systemProperties() overriding
        EnvironmentVariables() overriding
        ConfigurationProperties.fromFile(File("kstats.properties")) overriding
        ConfigurationProperties.fromResource("default.properties")

object Config {
    object teamcity : PropertyGroup() {
        val url by stringType
        val guest by booleanType
        val user by stringType
        val password by stringType
    }
}
