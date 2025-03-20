package com.wise.mall.product.application.error

import com.wise.mall.global.exception.ApplicationError

enum class ProductError(
    val code: Int,
    val message: String
) : ApplicationError {

    PRODUCT_NOT_FOUND(100, "상품을 찾을 수 없습니다."),
    PRODUCT_INVALID_PRICE(101, "금액은 0보다 작을 수 없습니다.")
    ;

    override fun getCode(): Int = this.code
    override fun getMessage(): String = this.message
}