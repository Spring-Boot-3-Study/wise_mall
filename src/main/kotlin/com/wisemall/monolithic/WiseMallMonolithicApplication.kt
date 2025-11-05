package com.wisemall.monolithic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WiseMallMonolithicApplication

fun main(args: Array<String>) {
    runApplication<WiseMallMonolithicApplication>(*args)
}
