package com.wise.mall.order.application.service

import com.wise.mall.order.application.command.OrderCreateCommand
import com.wise.mall.order.application.port.`in`.OrderCreateUseCase
import com.wise.mall.order.application.port.out.OrderPersistPort
import com.wise.mall.order.domain.vo.OrderItemToCreate
import com.wise.mall.order.domain.vo.OrderToCreate
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderPersistPort: OrderPersistPort,
): OrderCreateUseCase {
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

}