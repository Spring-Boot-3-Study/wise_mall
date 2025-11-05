plugins {
	kotlin("jvm")
	id("org.springframework.boot") apply false
	id("io.spring.dependency-management")
}

val springCloudVersion by extra("2024.0.1")

allprojects {
	apply(plugin = "kotlin")

	repositories {
		gradlePluginPortal()
		mavenCentral()
	}
	kotlin {
		jvmToolchain(21)
		compilerOptions {
			freeCompilerArgs.addAll("-Xjsr305=strict")
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

subprojects {
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.springframework.boot")

	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(17)
		}
	}


	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:${rootProject.extra["springCloudVersion"]}")
		}
	}


	group = "com.wise.mall"
	version = "0.0.1"


}