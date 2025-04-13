package com.wise.mall.order.application.service

import com.wise.mall.order.adapter.`in`.web.dto.response.OrderDetailsResponse
import com.wise.mall.order.application.command.OrderCreateCommand
import com.wise.mall.order.application.port.`in`.OrderUseCase
import com.wise.mall.order.application.port.out.OrderPersistPort
import com.wise.mall.order.domain.vo.OrderItemToCreate
import com.wise.mall.order.domain.vo.OrderToCreate
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderPersistPort: OrderPersistPort,
): OrderUseCase {
    override fun createOrder(orderCreateCommand: OrderCreateCommand) {


        val order = OrderToCreate(
            accountId = orderCreateCommand.accountId,
            orderItem = orderCreateCommand.orderItem.map { OrderItemToCreate(
                    productId = it.productId,
                    quantity = it.quantity
                ) }.toList(),
            address = orderCreateCommand.address
        )

        orderPersistPort.createOrder(order)

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