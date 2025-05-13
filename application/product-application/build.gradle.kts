plugins {
	kotlin("jvm")
}

dependencies {

	implementation(project(":domain:product-domain"))
	implementation(project(":common"))
	implementation("org.springframework:spring-context:6.1.14")
}