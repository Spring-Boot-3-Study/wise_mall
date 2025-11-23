package com.wisemall.monolithic.v1.delivery.api.dto


data class DeliveryCreateRequest (
    val orderId: Long,
    val carrier: String,
    val trackNumber: String
){

}