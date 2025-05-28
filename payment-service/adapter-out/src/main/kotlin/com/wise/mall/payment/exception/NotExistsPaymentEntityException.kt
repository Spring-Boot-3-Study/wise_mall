package com.wise.mall.payment.exception

import com.wise.mall.common.exception.ErrorException

class NotExistsPaymentEntityException(
    private val id: Long
): ErrorException (
    errorCode = PaymentAdapterErrorCode.PAYMENT_NOT_EXIST_PAYMENT_ENTITY,
    result = mapOf("id" to id.toString()),
)