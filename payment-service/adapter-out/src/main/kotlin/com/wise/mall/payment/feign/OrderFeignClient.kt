package com.wise.mall.payment.feign


import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name="order-service")
interface OrderFeignClient {

    @PutMapping("/api/order/{orderId}")
    fun changeOrderStatus(
        @PathVariable("orderId") orderId: Long,
        @RequestParam(value = "status") status: String
    )
}