package com.wise.mall.v1.order.domain.exception

import com.wise.mall.v1.global.exception.ErrorCode

enum class OrderErrorCode(
    private val code: Int,
    private val message: String,
) : ErrorCode {

    ORDER_NOT_EXISTS(100, "해당 주문 엔티티가 존재하지 않습니다.");

    override fun getCode(): Int = this.code
    override fun getMessage(): String = this.message
}