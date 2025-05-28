plugins {
    kotlin("jvm")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}
val springCloudVersion by extra("2024.0.1")

dependencies {

    implementation(project(":common"))
    implementation(project(":delivery-service:domain"))
    implementation(project(":delivery-service:application"))
    implementation(project(":delivery-service:adapter-in"))
    implementation(project(":delivery-service:adapter-out"))

    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
//	developmentOnly("org.springframework.boot:spring-boot-devtools")
}
dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

tasks.bootRun {
    mainClass.set("com.wise.mall.DeliveryServiceApplicationKt")
}

tasks.bootJar {
    enabled = true
}

tasks.jar {
    enabled = true
}