package com.wise.mall.product.application.exception

import com.wise.mall.global.exception.ErrorCode

enum class ProductApplicationErrorCode(
    private val code: Int,
    private val message: String,
) : ErrorCode {

    PRODUCT_INVALID_STATE(100, "승인 요청이 불가능한 상태입니다."),
    PRODUCT_INVALID_PRICE(101, "금액은 0보다 작을 수 없습니다.")
    ;

    override fun getCode(): Int = this.code
    override fun getMessage(): String = this.message
}