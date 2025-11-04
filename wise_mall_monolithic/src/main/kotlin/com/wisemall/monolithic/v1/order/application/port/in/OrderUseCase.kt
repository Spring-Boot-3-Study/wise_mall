package com.wise.mall.v1.order.application.port.`in`

import com.wise.mall.v1.order.adapter.`in`.web.dto.response.OrderDetailsResponse
import com.wise.mall.v1.order.application.command.OrderCreateCommand


interface OrderUseCase {
    fun createOrder(orderCreateCommand: OrderCreateCommand): OrderDetailsResponse
    fun getOrderDetails(orderId: Long): OrderDetailsResponse

}