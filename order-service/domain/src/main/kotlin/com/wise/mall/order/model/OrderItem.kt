package com.wise.mall.order.model


data class OrderItem(
    val productId: Long,
    val quantity: Int,
    val price: Int,
) {
    val subtotal: Int = quantity * price
}