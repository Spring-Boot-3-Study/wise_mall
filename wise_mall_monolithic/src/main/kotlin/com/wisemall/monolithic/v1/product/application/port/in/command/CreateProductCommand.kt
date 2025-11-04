package com.wise.mall.v1.product.application.port.`in`.command

data class CreateProductCommand(

    val name: String,

    val price: Int,
)