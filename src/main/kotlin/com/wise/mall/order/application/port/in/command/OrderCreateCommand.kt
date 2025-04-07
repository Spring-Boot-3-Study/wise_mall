package com.wise.mall.order.application.port.`in`.command

import com.wise.mall.global.vo.Address

data class OrderCreateCommand(
    val customerId: String,
    val orderItem: List<OrderItemCreateCommand>,
    val address: Address,
) {

}