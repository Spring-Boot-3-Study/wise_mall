package com.wisemall.monolithic.v1.product.exception

import com.wisemall.monolithic.v1.global.exception.ErrorCode

enum class ProductErrorCode(
    private val code: Int,
    private val message: String,
) : ErrorCode {

    PRODUCT_INVALID_PRICE(100, "금액은 0보다 작을 수 없습니다."),
    PRODUCT_NOT_EXISTS_PRODUCT_ENTITY(101, "상품 엔티티가 존재하지 않습니다.")
    ;

    override fun getCode(): Int = this.code
    override fun getMessage(): String = this.message
}