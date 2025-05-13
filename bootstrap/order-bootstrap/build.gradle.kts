plugins {
	kotlin("jvm")
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("plugin.spring")
	kotlin("plugin.jpa")

}

dependencies {

	implementation(project(":common"))
	implementation(project(":domain:order-domain"))
	implementation(project(":application:order-application"))
	implementation(project(":adapter-in:order-adapter-in"))
	implementation(project(":adapter-out:order-adapter-out"))

	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("org.springframework.boot:spring-boot-starter")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
}