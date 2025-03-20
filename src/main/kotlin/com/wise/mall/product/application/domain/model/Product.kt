package com.wise.mall.product.application.domain.model

data class Product (

    val id : Long,

    val name: String,

    val price: Int,

    val state: Int,
)