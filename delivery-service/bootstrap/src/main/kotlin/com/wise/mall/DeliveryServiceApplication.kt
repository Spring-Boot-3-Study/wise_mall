package com.wise.mall

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class DeliveryServiceApplication

fun main(args: Array<String>) {
	runApplication<DeliveryServiceApplication>(*args)
}
