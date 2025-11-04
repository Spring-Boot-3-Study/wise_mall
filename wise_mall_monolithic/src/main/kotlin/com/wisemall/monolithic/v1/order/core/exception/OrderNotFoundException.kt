package com.wisemall.monolithic.v1.order.domain.exception

import com.wisemall.monolithic.v1.global.exception.ErrorException

class OrderNotFoundException(
    val orderId: Long,
): ErrorException(
    errorCode = OrderErrorCode.ORDER_NOT_EXISTS,
    result = mapOf("id" to orderId.toString()),) {
}