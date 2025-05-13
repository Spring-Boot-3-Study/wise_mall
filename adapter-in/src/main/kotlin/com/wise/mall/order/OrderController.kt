package com.wise.mall.order.web

import com.wise.mall.order.port.`in`.OrderUseCase
import com.wise.mall.order.web.dto.request.OrderCreateRequest
import com.wise.mall.order.web.dto.response.OrderDetailsResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/order")
class OrderController(
    private val orderUseCase: OrderUseCase
) {
    @PostMapping
    fun createOrder(@RequestBody createOrderRequest: OrderCreateRequest): ResponseEntity<OrderDetailsResponse> {
        val orderCreateCommand = createOrderRequest.toCommand()

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(orderUseCase.createOrder(orderCreateCommand))
    }

    @GetMapping("/{orderId}")
    fun getOrder(@PathVariable orderId: Long): ResponseEntity<OrderDetailsResponse> {

        return ResponseEntity.ok(
            orderUseCase.getOrderDetails(orderId)
        )
    }
}