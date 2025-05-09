package com.wise.mall.order.model

import com.wise.mall.common.vo.Address
import java.time.LocalDateTime

class Order(
    val orderId: Long,
    val accountId: String,
    val address: Address,
    status: OrderStatus,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val totalPrice: Int,
) {

    var status = status
        private set


    fun updateOrderStatus(status: OrderStatus) {
        this.status = status
    }

}