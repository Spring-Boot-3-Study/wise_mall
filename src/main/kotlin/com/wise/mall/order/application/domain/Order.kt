package com.wise.mall.order.application.domain

import com.wise.mall.global.vo.Address
import java.time.LocalDateTime

data class Order(
    val orderId: Long,
    // customer 추후 변경
    val customerId: String,
    val orderItems: List<OrderItem>,
    val address: Address,
    var status: OrderStatus,
    val createdAt: LocalDateTime,
) {
    val totalPrice: Int = orderItems.sumOf { it.subtotal }

}