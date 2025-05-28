package com.wise.mall.order.port.`in`

import com.wise.mall.order.dto.response.OrderDetailsResponse

interface GetOrderUseCase {
    fun getOrderByOrderId(orderId: Long): OrderDetailsResponse
}