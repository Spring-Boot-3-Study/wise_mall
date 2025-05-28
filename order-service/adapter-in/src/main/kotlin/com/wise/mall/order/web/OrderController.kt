package com.wise.mall.order.web

import com.wise.mall.order.port.`in`.CreateOrderUseCase
import com.wise.mall.order.port.`in`.GetOrderUseCase
import com.wise.mall.order.web.dto.request.OrderCreateRequest
import com.wise.mall.order.dto.response.OrderDetailsResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/order")
class OrderController(
    private val createOrderUseCase: CreateOrderUseCase,
    private val getOrderUseCase: GetOrderUseCase
) {
    @PostMapping
    fun createOrder(@RequestBody createOrderRequest: OrderCreateRequest): ResponseEntity<OrderDetailsResponse> {
        val orderCreateCommand = createOrderRequest.toCommand()

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(createOrderUseCase.createOrder(orderCreateCommand))
    }

    @GetMapping("/{orderId}")
    fun getOrder(@PathVariable orderId: Long): ResponseEntity<OrderDetailsResponse> {

        return ResponseEntity.ok(
            getOrderUseCase.getOrderByOrderId(orderId)
        )
    }
}