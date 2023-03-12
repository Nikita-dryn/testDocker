package com.testDocker.testDocker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestDockerApplication

fun main(args: Array<String>) {
	runApplication<TestDockerApplication>(*args)
}
