package com.wise.mall.order.dto.response

import com.wise.mall.common.vo.Address
import com.wise.mall.order.model.OrderItem
import com.wise.mall.order.model.OrderStatus


data class OrderDetailsResponse(
    val orderId: Long,
    val accountId: String,
    val address: Address,
    val orderItems:List<OrderItem>,
    val status: OrderStatus,
    val totalPrice: Int,
) {

}