package com.wise.mall.order.domain.model

import com.wise.mall.product.application.domain.model.Product


data class OrderItem(
    val product: Product,
    val quantity: Int,
    val price: Int,
) {
    val subtotal: Int = quantity * price
}