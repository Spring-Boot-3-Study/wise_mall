package com.wise.mall.order.port.`in`

import com.wise.mall.order.command.OrderCreateCommand
import com.wise.mall.order.web.dto.response.OrderDetailsResponse


interface OrderUseCase {
    fun createOrder(orderCreateCommand: OrderCreateCommand): OrderDetailsResponse
    fun getOrderDetails(orderId: Long): OrderDetailsResponse

}