package com.wise.mall.product.application.port.out.vo

import com.wise.mall.product.application.domain.model.Product
import java.time.LocalDateTime

data class ProductVo(

    val id: Long,

    val name: String,

    val price: Int,

    val state: Int,

    val createdAt: LocalDateTime,

    val updatedAt: LocalDateTime,
) {
    fun toProduct() = Product(
        id = this.id,
        name = this.name,
        price = this.price,
        state = this.state,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )
}