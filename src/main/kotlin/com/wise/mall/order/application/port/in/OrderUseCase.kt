package com.wise.mall.order.application.port.`in`

import com.wise.mall.order.adapter.`in`.web.dto.response.OrderDetailsResponse
import com.wise.mall.order.application.command.OrderCreateCommand


interface OrderUseCase {
    fun createOrder(orderCreateCommand: OrderCreateCommand): OrderDetailsResponse
    fun getOrderDetails(orderId: Long): OrderDetailsResponse

}