package com.wisemall.monolithic.v1.product.exception

import com.wisemall.monolithic.v1.global.exception.ErrorException

class NotExistsProductException (
    private val id: Long,
): ErrorException(
    errorCode = ProductErrorCode.PRODUCT_NOT_EXISTS_PRODUCT_ENTITY,
    result = mapOf("id" to id.toString()),
)