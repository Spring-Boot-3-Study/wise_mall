package com.wise.mall.order.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["com.wise.mall.order.client"])
class FeignConfig {
}