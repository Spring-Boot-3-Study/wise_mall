package com.wisemall.monolithic.v1.product.service.vo

import java.time.LocalDateTime

data class Product (

    val id: Long,

    var name: String,

    var price: Int,

    var state: Int,

    val createdAt: LocalDateTime,

    val updatedAt: LocalDateTime,
)