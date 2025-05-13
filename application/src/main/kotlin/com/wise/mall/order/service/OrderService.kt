package com.wise.mall.order.service

import com.wise.mall.order.command.OrderCreateCommand
import com.wise.mall.order.port.`in`.OrderUseCase
import com.wise.mall.order.port.out.OrderPersistPort
import com.wise.mall.order.vo.OrderItemToCreate
import com.wise.mall.order.vo.OrderToCreate
import com.wise.mall.order.web.dto.response.OrderDetailsResponse
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderPersistPort: OrderPersistPort,
): OrderUseCase {
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


    override fun getOrderDetails(orderId: Long): OrderDetailsResponse {
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