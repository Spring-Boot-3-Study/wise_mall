plugins {
	kotlin("jvm")
	id("org.springframework.boot") apply false
	id("io.spring.dependency-management") apply false
}

allprojects {
	apply(plugin = "kotlin")

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

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

subprojects {

	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(17)
		}
	}


	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.springframework.boot")
	group = "com.wise.mall"
	version = "0.0.1"


}