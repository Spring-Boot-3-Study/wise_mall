package com.wise.mall.v1.order.application.command

import com.wise.mall.v1.global.vo.Address

data class OrderCreateCommand(
    val accountId: String,
    val orderItem: List<OrderItemCreateCommand>,
    val address: Address,
) {

}