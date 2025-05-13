plugins {
	kotlin("jvm")
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("plugin.spring")
	kotlin("plugin.jpa")

}

dependencies {

	implementation(project(":common"))
	implementation(project(":domain:payment-domain"))
	implementation(project(":application:payment-application"))
	implementation(project(":adapter-in:payment-adapter-in"))
	implementation(project(":adapter-out:payment-adapter-out"))

	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("org.springframework.boot:spring-boot-starter")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
}