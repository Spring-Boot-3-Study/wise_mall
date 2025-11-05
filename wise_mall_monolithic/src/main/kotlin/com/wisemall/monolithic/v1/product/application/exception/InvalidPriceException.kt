package com.wisemall.monolithic.v1.product.application.exception

import com.wisemall.monolithic.v1.global.exception.ErrorException

class InvalidPriceException (
    private val price: Int,
): ErrorException(
    errorCode = ProductApplicationErrorCode.PRODUCT_INVALID_PRICE,
    result = mapOf("price" to price),
)