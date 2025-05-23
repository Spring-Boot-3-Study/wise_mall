package com.wise.mall.product.application.vo

import com.wise.mall.product.application.domain.model.Product

data class UpdateProductVo(

    val id: Long,

    val name: String,

    val price: Int,

    val state: Int,
) {
    companion object {
        fun of(product: Product): UpdateProductVo = UpdateProductVo(
            id = product.id,
            name = product.name,
            price = product.price,
            state = product.state,
        )
    }
}
