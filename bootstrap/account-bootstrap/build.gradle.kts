plugins {
	kotlin("jvm")
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("plugin.spring")
	kotlin("plugin.jpa")

}

dependencies {

	implementation(project(":common"))
	implementation(project(":domain:account-domain"))
	implementation(project(":application:account-application"))
	implementation(project(":adapter-in:account-adapter-in"))
	implementation(project(":adapter-out:account-adapter-out"))

	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("org.springframework.boot:spring-boot-starter")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
}