plugins {
	kotlin("jvm")
}

dependencies {
	implementation(project(":domain"))
	implementation("org.springframework:spring-context:6.1.14")
}