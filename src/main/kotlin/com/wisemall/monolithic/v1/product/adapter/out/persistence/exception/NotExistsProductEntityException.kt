package com.wisemall.monolithic.v1.product.adapter.out.persistence.exception

import com.wisemall.monolithic.v1.global.exception.ErrorException

class NotExistsProductEntityException (
    private val id: Long,
): ErrorException(
    errorCode = ProductAdapterErrorCode.PRODUCT_NOT_EXISTS_PRODUCT_ENTITY,
    result = mapOf("id" to id.toString()),
)