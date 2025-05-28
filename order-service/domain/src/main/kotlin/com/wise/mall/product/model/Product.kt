package com.wise.mall.product.model

import java.time.LocalDateTime

data class Product (

    val id: Long,

    var name: String,

    var price: Int,

    var isApprove: Boolean
)