package com.wise.mall.order.adapter.`in`.web

import com.wise.mall.order.adapter.`in`.web.dto.request.OrderCreateRequest
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/orders")
class OrderController(
    private val createOrderUseCase: OrderCreateUseCase
) {
    fun createOrder(createOrderRequest: OrderCreateRequest) {
        val orderCreateCommand = createOrderRequest.toCommand()
        createOrderUseCase.createOrder(orderCreateCommand)
    }
}