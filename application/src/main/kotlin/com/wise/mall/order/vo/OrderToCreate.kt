package com.wise.mall.order.vo

import com.wise.mall.common.vo.Address


data class OrderToCreate(
    val accountId: String,
    val orderItem: List<OrderItemToCreate>,
    val address: Address,
) {
}