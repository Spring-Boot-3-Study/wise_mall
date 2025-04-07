package com.wise.mall.order.application.port.`in`

import com.wise.mall.order.application.port.`in`.command.OrderCreateCommand


interface OrderCreateUseCase {
    fun createOrder(orderCreateCommand: OrderCreateCommand)
}