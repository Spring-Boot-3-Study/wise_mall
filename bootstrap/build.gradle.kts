plugins {
	kotlin("jvm")
}

dependencies {
	implementation(project(":adapter-in"))
	implementation("org.springframework.boot:spring-boot-starter")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
}