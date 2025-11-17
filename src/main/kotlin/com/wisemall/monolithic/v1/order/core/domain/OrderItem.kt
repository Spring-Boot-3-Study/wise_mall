package com.wisemall.monolithic.v1.order.core.domain

import com.wisemall.monolithic.v1.product.service.vo.Product


data class OrderItem(
    val product: Product,
    val quantity: Int,
    val price: Int,
) {
    val subtotal: Int = quantity * price
}