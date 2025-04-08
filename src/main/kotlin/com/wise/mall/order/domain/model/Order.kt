package com.wise.mall.order.domain.model

import com.wise.mall.global.vo.Address
import java.time.LocalDateTime

data class Order(
    val orderId: Long? = null,
    // customer 추후 변경
    val accountId: String,
//    val orderItems: List<OrderItem>,
    val address: Address,
    var status: OrderStatus,
    val createdAt: LocalDateTime? = null,
    val totalPrice: Int? = null,
) {

}