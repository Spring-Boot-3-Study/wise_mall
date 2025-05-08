package com.wise.mall.order.exception

import com.wise.mall.global.exception.ErrorException

class OrderNotFoundException(
    val orderId: Long,
): ErrorException(
    errorCode = OrderErrorCode.ORDER_NOT_EXISTS,
    result = mapOf("id" to orderId.toString()),) {
}