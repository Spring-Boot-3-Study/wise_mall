package com.wisemall.monolithic.v1.payment.application.exception

class OrderInvalidException(
    override val message: String = "invalid Order",
): RuntimeException(message) {
}