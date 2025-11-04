package com.wise.mall.v1.product.application.port.`in`.command

data class GetProductsCommand(

    val page: Int,

    val size: Int,
)