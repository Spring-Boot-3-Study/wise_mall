plugins {
	kotlin("jvm")
}

dependencies {

	implementation(project(":domain:payment-domain"))
	implementation(project(":common"))
	implementation("org.springframework:spring-context:6.1.14")
}