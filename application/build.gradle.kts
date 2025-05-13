plugins {
	kotlin("jvm")
}

dependencies {

	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

	implementation(project(":domain"))
	implementation(project(":common"))
	implementation("org.springframework:spring-context:6.1.14")
}