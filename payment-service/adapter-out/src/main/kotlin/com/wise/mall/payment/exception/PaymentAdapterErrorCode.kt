package com.wise.mall.payment.exception

import com.wise.mall.common.exception.ErrorCode

enum class PaymentAdapterErrorCode(
    private val code: Int,
    private val message: String,
) : ErrorCode {

    PAYMENT_NOT_EXIST_PAYMENT_ENTITY(100, "결제정보 엔티티가 존재하지 않습니다.")
    ;

    override fun getCode(): Int = this.code
    override fun getMessage(): String = this.message
}