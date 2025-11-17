package com.wisemall.monolithic.v1.delivery.api.dto

data class OrderResponse (
    val orderId: Long,
    val status: String,
    val carrier: String,
    val trackNumber: String,
) {
}