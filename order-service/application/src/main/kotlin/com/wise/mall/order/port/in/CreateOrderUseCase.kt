package com.wise.mall.order.port.`in`

import com.wise.mall.order.command.OrderCreateCommand
import com.wise.mall.order.dto.response.OrderDetailsResponse

interface CreateOrderUseCase {
    fun createOrder(orderCreateCommand: OrderCreateCommand): OrderDetailsResponse
}