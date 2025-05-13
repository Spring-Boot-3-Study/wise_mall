package com.wise.mall.product.exception

import com.wise.mall.common.exception.ErrorException


class InvalidPriceException (
    private val price: Int,
): ErrorException(
    errorCode = ProductApplicationErrorCode.PRODUCT_INVALID_PRICE,
    result = mapOf("price" to price),
)