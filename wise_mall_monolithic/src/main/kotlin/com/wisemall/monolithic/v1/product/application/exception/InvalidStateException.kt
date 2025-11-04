package com.wise.mall.v1.product.application.exception

import com.wise.mall.v1.global.exception.ErrorException

class InvalidStateException (
    private val id: Long,
): ErrorException(
    errorCode = ProductApplicationErrorCode.PRODUCT_INVALID_STATE,
    result = mapOf("id" to id.toString()),
)