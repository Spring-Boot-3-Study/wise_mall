plugins {
    kotlin("jvm")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}

dependencies {

    implementation(project(":common"))
    implementation(project(":order-service:domain"))
    implementation(project(":order-service:application"))
    implementation(project(":order-service:adapter-in"))
    implementation(project(":order-service:adapter-out"))

    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
//	developmentOnly("org.springframework.boot:spring-boot-devtools")
}
