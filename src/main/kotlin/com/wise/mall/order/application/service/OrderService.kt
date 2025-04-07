package com.wise.mall.order.application.service

import com.wise.mall.order.application.port.`in`.OrderCreateUseCase
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderPersistPort: OrderPersistPort,
): OrderCreateUseCase {
    override fun createOrder(orderCreateCommand: OrderCreateCommand) {

    }

}