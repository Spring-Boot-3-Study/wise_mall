package com.wise.mall.order.model

import com.wise.mall.product.model.Product


data class OrderItem(
    val product: Product,
    val quantity: Int,
    val price: Int,
) {
    val subtotal: Int = quantity * price
}