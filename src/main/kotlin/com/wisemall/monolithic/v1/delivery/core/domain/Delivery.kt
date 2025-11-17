package com.wisemall.monolithic.v1.delivery.core.domain

import java.time.LocalDateTime

class Delivery(
    val orderId: Long,
    val carrier: String,
    val trackingNumber: String,
    val shippingDate: LocalDateTime = LocalDateTime.now(),
) {
    companion object{
        fun create(orderId: Long, carrier: String, trackingNumber: String): Delivery {
            return Delivery (
                orderId = orderId,
                carrier = carrier,
                trackingNumber = trackingNumber,
            )
        }
    }
}