package com.wise.mall.product.persistence.exception

import com.wise.mall.common.exception.ErrorException

class NotExistsProductEntityException (
    private val id: Long,
): ErrorException(
    errorCode = ProductAdapterErrorCode.PRODUCT_NOT_EXISTS_PRODUCT_ENTITY,
    result = mapOf("id" to id.toString()),
)