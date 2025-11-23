package com.wisemall.monolithic.v1.order.api

import com.wisemall.monolithic.v1.order.api.dto.request.OrderCreateRequest
import com.wisemall.monolithic.v1.order.api.dto.response.OrderDetailsResponse
import com.wisemall.monolithic.v1.order.core.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/order")
class OrderController(
    private val orderService: OrderService

) {
    @PostMapping
    fun createOrder(@RequestBody createOrderRequest: OrderCreateRequest): ResponseEntity<OrderDetailsResponse> {
        val orderCreateCommand = createOrderRequest.toCommand()

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(orderService.createOrder(orderCreateCommand))
    }

    @GetMapping("/{orderId}")
    fun getOrder(@PathVariable orderId: Long): ResponseEntity<OrderDetailsResponse> {

        return ResponseEntity.ok(
            orderService.getOrderDetails(orderId)
        )
    }
}