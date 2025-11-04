package com.wise.mall.v1.order.adapter.`in`.web.dto.response

import com.wise.mall.v1.global.vo.Address
import com.wise.mall.v1.order.domain.model.OrderItem
import com.wise.mall.v1.order.domain.model.OrderStatus

data class OrderDetailsResponse(
    val orderId: Long,
    val accountId: String,
    val address: Address,
    val orderItems:List<OrderItem>,
    val status: OrderStatus,
    val totalPrice: Int,
) {

}