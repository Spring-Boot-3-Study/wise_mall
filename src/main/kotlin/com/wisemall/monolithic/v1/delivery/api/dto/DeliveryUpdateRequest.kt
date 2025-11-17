package com.wisemall.monolithic.v1.delivery.api.dto

data class DeliveryUpdateRequest (
    val orderId: Long,
    val status: DeliveryStatus,
) {
}