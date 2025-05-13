 plugins {
	 kotlin("jvm")
	 kotlin("plugin.jpa")
	 kotlin("plugin.spring")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

dependencies {
	implementation(project(":application:payment-application"))
	implementation(project(":domain:payment-domain"))
	implementation(project(":common"))

	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
}
 allOpen {
	 annotation("jakarta.persistence.Entity")
	 annotation("jakarta.persistence.MappedSuperclass")
	 annotation("jakarta.persistence.Embeddable")
 }