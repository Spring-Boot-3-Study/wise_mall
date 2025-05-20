plugins {
    kotlin("jvm")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}
val springCloudVersion by extra("2024.0.1")

dependencies {

    implementation(project(":common"))
    implementation(project(":account-service:domain"))
    implementation(project(":account-service:application"))
    implementation(project(":account-service:adapter-in"))
    implementation(project(":account-service:adapter-out"))

    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
//	developmentOnly("org.springframework.boot:spring-boot-devtools")
}
dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}
