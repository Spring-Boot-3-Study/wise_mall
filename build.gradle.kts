plugins {
	kotlin("jvm")
	id("org.springframework.boot") apply false
	id("io.spring.dependency-management") apply false
}

allprojects {
	apply(plugin = "kotlin")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.springframework.boot")
	group = "com.wise.mall"
	version = "0.0.1"
	repositories {
		gradlePluginPortal()
		mavenCentral()
	}

	kotlin {
		jvmToolchain(17)
		compilerOptions {
			freeCompilerArgs.addAll("-Xjsr305=strict")
		}
	}
//	dependencies {}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}
//
//
//dependencies {
//	implementation("org.springframework.boot:spring-boot-starter-web")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	developmentOnly("org.springframework.boot:spring-boot-devtools")			// adapter in
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
////	runtimeOnly("com.h2database:h2")
//	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
//
//	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
//	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
//	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
//}
//
//allOpen {
//	annotation("jakarta.persistence.Entity")
//	annotation("jakarta.persistence.MappedSuperclass")
//	annotation("jakarta.persistence.Embeddable")
//}
