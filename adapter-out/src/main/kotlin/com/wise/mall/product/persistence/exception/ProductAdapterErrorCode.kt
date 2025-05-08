package com.wise.mall.product.persistence.exception

import com.wise.mall.global.exception.ErrorCode

enum class ProductAdapterErrorCode(
    private val code: Int,
    private val message: String,
) : ErrorCode {

    PRODUCT_NOT_EXISTS_PRODUCT_ENTITY(100, "상품 엔티티가 존재하지 않습니다.")
    ;

    override fun getCode(): Int = this.code
    override fun getMessage(): String = this.message
}