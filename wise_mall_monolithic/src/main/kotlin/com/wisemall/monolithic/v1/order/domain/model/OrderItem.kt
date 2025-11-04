package com.wise.mall.v1.order.domain.model

import com.wise.mall.v1.product.application.domain.model.Product


data class OrderItem(
    val product: Product,
    val quantity: Int,
    val price: Int,
) {
    val subtotal: Int = quantity * price
}