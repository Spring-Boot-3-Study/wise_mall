plugins {
    kotlin("jvm")
}

dependencies {

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation(project(":payment-service:application"))
    implementation(project(":common"))

}