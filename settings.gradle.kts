pluginManagement {
    plugins {
        id("org.springframework.boot") version "3.4.5"
        id("io.spring.dependency-management") version "1.1.7"
        kotlin("jvm") version "1.9.25"
        kotlin("plugin.spring") version "1.9.25"
        kotlin("plugin.jpa") version "1.9.25"
    }
}

rootProject.name = "wise_mall"

include("service-discovery")

include("account-service")
include("delivery-service")
include("order-service")
include("payment-service")
include("product-service")
include("common")

include("account-service:bootstrap")
include("account-service:adapter-in")
include("account-service:adapter-out")
include("account-service:application")
include("account-service:domain")


include("delivery-service:bootstrap")
include("delivery-service:adapter-in")
include("delivery-service:adapter-out")
include("delivery-service:application")
include("delivery-service:domain")


include("order-service:bootstrap")
include("order-service:adapter-in")
include("order-service:adapter-out")
include("order-service:application")
include("order-service:domain")


include("payment-service:bootstrap")
include("payment-service:adapter-in")
include("payment-service:adapter-out")
include("payment-service:application")
include("payment-service:domain")


include("product-service:bootstrap")
include("product-service:adapter-in")
include("product-service:adapter-out")
include("product-service:application")
include("product-service:domain")