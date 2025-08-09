plugins {
	id("org.springframework.boot") version "3.5.4"
	id("io.spring.dependency-management") version "1.1.5"
	java
}

group = "com.example"
version = "1.0.0"
java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(21))
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
	useJUnitPlatform()
}
