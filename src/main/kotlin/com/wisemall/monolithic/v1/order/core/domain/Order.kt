package com.wisemall.monolithic.v1.order.core.domain

import com.wisemall.monolithic.v1.global.vo.Address
import com.wisemall.monolithic.v1.order.core.enums.OrderStatus
import java.time.LocalDateTime

class Order(
    val orderId: Long,
    val accountId: Long,
    val address: Address,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val amount: Int,
    status: OrderStatus,
) {

    var status = status
        private set


    fun updateOrderStatus(status: OrderStatus) {
        this.status = status
    }

}