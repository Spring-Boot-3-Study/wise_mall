package com.wise.mall

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients


@SpringBootApplication
@EnableFeignClients(basePackages = ["com.wise.mall.payment.feign"])
@EnableDiscoveryClient
class PaymentServiceApplication

fun main(args: Array<String>) {
	runApplication<PaymentServiceApplication>(*args)
}
