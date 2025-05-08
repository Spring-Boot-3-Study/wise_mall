package com.wise.mall.order.command

import com.wise.mall.global.vo.Address

data class OrderCreateCommand(
    val accountId: String,
    val orderItem: List<OrderItemCreateCommand>,
    val address: Address,
) {

}