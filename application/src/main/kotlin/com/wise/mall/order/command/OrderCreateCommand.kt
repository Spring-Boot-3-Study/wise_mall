package com.wise.mall.order.command

import com.wise.mall.common.vo.Address


data class OrderCreateCommand(
    val accountId: String,
    val orderItem: List<OrderItemCreateCommand>,
    val address: Address,
) {

}