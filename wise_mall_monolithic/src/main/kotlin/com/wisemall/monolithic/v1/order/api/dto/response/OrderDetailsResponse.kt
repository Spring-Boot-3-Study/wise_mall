package com.wisemall.monolithic.v1.order.api.dto.response

import com.wisemall.monolithic.v1.global.vo.Address
import com.wisemall.monolithic.v1.order.core.domain.OrderItem
import com.wisemall.monolithic.v1.order.core.enums.OrderStatus

data class OrderDetailsResponse(
    val orderId: Long,
    val accountId: String,
    val address: Address,
    val orderItems:List<OrderItem>,
    val status: OrderStatus,
    val totalPrice: Int,
) {

}