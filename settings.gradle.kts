pluginManagement {
    plugins {
        id("org.springframework.boot") version "3.3.5"
        id("io.spring.dependency-management") version "1.1.6"
        kotlin("jvm") version "1.9.25"
        kotlin("plugin.spring") version "1.9.25"
        kotlin("plugin.jpa") version "1.9.25"
    }
}

rootProject.name = "wise_mall"
include("bootstrap")
include("adapter-in")
include("adapter-out")
include("application")
include("domain")

include("common")