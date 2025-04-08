package com.wise.mall.order.application.service

import com.wise.mall.order.domain.model.Order
import com.wise.mall.order.domain.model.OrderItem
import com.wise.mall.order.domain.model.OrderStatus
import com.wise.mall.order.application.port.`in`.OrderCreateUseCase
import com.wise.mall.order.application.command.OrderCreateCommand
import com.wise.mall.order.application.port.out.OrderPersistPort
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderPersistPort: OrderPersistPort,
): OrderCreateUseCase {
    override fun createOrder(orderCreateCommand: OrderCreateCommand) {

        // product 조회



        val orderItems =
            orderCreateCommand.orderItem.map {
                OrderItem(

                )
            }.toList()


        val order = Order(
            accountId = orderCreateCommand.accountId,
            status = OrderStatus.PENDING,
            address = orderCreateCommand.address,
        )
        orderPersistPort.createOrder(order)

    }

}