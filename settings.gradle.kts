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
include("bootstrap:account-bootstrap")
include("bootstrap:delivery-bootstrap")
include("bootstrap:order-bootstrap")
include("bootstrap:payment-bootstrap")
include("bootstrap:product-bootstrap")

include("adapter-in")
include("adapter-in:account-adapter-in")
include("adapter-in:delivery-adapter-in")
include("adapter-in:order-adapter-in")
include("adapter-in:payment-adapter-in")
include("adapter-in:product-adapter-in")

include("adapter-out")
include("adapter-out:account-adapter-out")
include("adapter-out:delivery-adapter-out")
include("adapter-out:order-adapter-out")
include("adapter-out:payment-adapter-out")
include("adapter-out:product-adapter-out")

include("application")
include("application:account-application")
include("application:delivery-application")
include("application:order-application")
include("application:payment-application")
include("application:product-application")

include("domain")
include("domain:account-domain")
include("domain:delivery-domain")
include("domain:order-domain")
include("domain:payment-domain")
include("domain:product-domain")

include("common")