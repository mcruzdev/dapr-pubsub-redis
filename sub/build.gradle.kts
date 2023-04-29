plugins {
	java
	id("org.springframework.boot") version "2.7.11-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.github.mcruzdev"
version = "0.1.0"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")


	implementation("io.dapr:dapr-sdk:1.8.0")
	implementation("io.dapr:dapr-sdk-springboot:1.8.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
