package com.wise.mall.v1.order.domain.exception

import com.wise.mall.v1.global.exception.ErrorException

class OrderNotFoundException(
    val orderId: Long,
): ErrorException(
    errorCode = OrderErrorCode.ORDER_NOT_EXISTS,
    result = mapOf("id" to orderId.toString()),) {
}