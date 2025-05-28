package com.wise.mall.order.service

import com.wise.mall.order.command.OrderCreateCommand
import com.wise.mall.order.port.`in`.CreateOrderUseCase
import com.wise.mall.order.port.`in`.DeleteOrderUseCase
import com.wise.mall.order.port.`in`.GetOrderUseCase
import com.wise.mall.order.port.`in`.ModifyOrderUseCase
import com.wise.mall.order.port.out.OrderPersistPort
import com.wise.mall.order.vo.OrderItemToCreate
import com.wise.mall.order.vo.OrderToCreate
import com.wise.mall.order.dto.response.OrderDetailsResponse
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderPersistPort: OrderPersistPort,
): CreateOrderUseCase, GetOrderUseCase, ModifyOrderUseCase, DeleteOrderUseCase {
    override fun createOrder(orderCreateCommand: OrderCreateCommand): OrderDetailsResponse {


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

        val order = orderPersistPort.createOrder(orderDto)
        val orderItems = orderPersistPort.getOrderItemsByOrderId(order.orderId)

        return OrderDetailsResponse(
            orderId = order.orderId,
            accountId = order.accountId,
            address = order.address,
            status = order.status,
            orderItems = orderItems,
            totalPrice = order.totalPrice,
        )

    }


    override fun getOrderByOrderId(orderId: Long): OrderDetailsResponse {
        val order = orderPersistPort.getOrderById(orderId)
        val orderItems = orderPersistPort.getOrderItemsByOrderId(orderId)
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