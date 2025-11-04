package com.wisemall.monolithic.v1.order.core.service

import com.wisemall.monolithic.v1.order.api.dto.OrderItemToCreate
import com.wisemall.monolithic.v1.order.api.dto.OrderToCreate
import com.wisemall.monolithic.v1.order.api.dto.response.OrderDetailsResponse
import com.wisemall.monolithic.v1.order.api.dto.OrderCreateCommand
import com.wisemall.monolithic.v1.order.core.usecase.OrderCreateUseCase
import com.wisemall.monolithic.v1.order.core.usecase.OrderFinder
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderFinder: OrderFinder,
    private val orderCreateUseCase: OrderCreateUseCase,
) {
    fun createOrder(orderCreateCommand: OrderCreateCommand): OrderDetailsResponse {

        val orderDto = OrderToCreate(
            accountId = orderCreateCommand.accountId,
            orderItem = orderCreateCommand.orderItem.map {
                OrderItemToCreate(
                    productId = it.productId,
                    quantity = it.quantity
                )
            }.toList(),
            address = orderCreateCommand.address
        )

        val order = orderCreateUseCase.createOrder(orderDto)
        val orderItems = orderFinder.getOrderItemsByOrderId(order.orderId)

        return OrderDetailsResponse(
            orderId = order.orderId,
            accountId = order.accountId,
            address = order.address,
            status = order.status,
            orderItems = orderItems,
            totalPrice = order.totalPrice,
        )

    }

    fun getOrderDetails(orderId: Long): OrderDetailsResponse {
        val order = orderFinder.getOrderById(orderId)
        val orderItems = orderFinder.getOrderItemsByOrderId(orderId)
        return OrderDetailsResponse(
            orderId = order.orderId,
            accountId = order.accountId,
            address = order.address,
            status = order.status,
            orderItems = orderItems,
            totalPrice = order.totalPrice,
        )
    }

}