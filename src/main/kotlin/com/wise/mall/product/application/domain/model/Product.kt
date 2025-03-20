package com.wise.mall.product.application.domain.model

import java.time.LocalDateTime

data class Product (

    val id: Long,

    val name: String,

    val price: Int,

    val state: Int,

    val createdAt: LocalDateTime,

    val updatedAt: LocalDateTime,
)