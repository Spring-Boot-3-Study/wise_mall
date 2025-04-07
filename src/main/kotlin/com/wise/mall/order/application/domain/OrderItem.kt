package com.wise.mall.order.application.domain

import com.wise.mall.product.application.domain.model.Product


data class OrderItem(
    val product: Product,
    val quantity: Int,
) {
    val price: Int = product.price
    val subtotal: Int = quantity * price
}