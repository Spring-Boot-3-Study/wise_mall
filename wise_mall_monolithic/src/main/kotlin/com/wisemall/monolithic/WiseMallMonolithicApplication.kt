package com.wisemall.monolithic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
class WiseMallMonolithicApplication

fun main(args: Array<String>) {
    runApplication<WiseMallMonolithicApplication>(*args)
}
