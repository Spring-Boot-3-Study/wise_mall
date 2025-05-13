plugins {
	kotlin("jvm")
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("plugin.spring")
	kotlin("plugin.jpa")

}

dependencies {

	implementation(project(":common"))
	implementation(project(":domain:delivery-domain"))
	implementation(project(":application:delivery-application"))
	implementation(project(":adapter-in:delivery-adapter-in"))
	implementation(project(":adapter-out:delivery-adapter-out"))

	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("org.springframework.boot:spring-boot-starter")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
}