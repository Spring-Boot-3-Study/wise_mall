package com.wise.mall.product.dto

import java.time.LocalDateTime

data class ProductDto(

    val id: Long,

    var name: String,

    var price: Int,

    var state: Int,

    val createdAt: LocalDateTime,

    val updatedAt: LocalDateTime,
)
