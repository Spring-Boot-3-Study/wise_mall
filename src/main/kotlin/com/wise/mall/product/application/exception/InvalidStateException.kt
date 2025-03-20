package com.wise.mall.product.application.exception

import com.wise.mall.global.exception.ErrorException

class InvalidStateException (
    private val id: Long,
): ErrorException(
    errorCode = ProductApplicationErrorCode.PRODUCT_INVALID_STATE,
    result = mapOf("id" to id.toString()),
)