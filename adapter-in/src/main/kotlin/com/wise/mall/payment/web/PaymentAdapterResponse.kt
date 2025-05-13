package com.wise.mall.payment.web

import com.wise.mall.common.response.Response


enum class PaymentAdapterResponse(
    private val code: Int,
    private val message: String
) : Response {
    PAYMENT_CREATE_PAYMENT_SUCCESS(100, "결제정보 저장에 성공했습니다."),
    PAYMENT_GET_DETAIL_PAYMENT_SUCCESS(200, "결제상세정보 조회에 성공했습니다."),
    PAYMENT_GET_ACCOUNT_PAYMENTS_SUCCESS(300, "사용자의 전체 결제정보 조회에 성공했습니다")
    ;
    override fun getCode(): Int = this.code
    override fun getMessage(): String = this.message
}