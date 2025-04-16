package com.wise.mall.delivery.adapter.`in`.web.dto.request

data class RegisterDeliveryRequestDto (
    val orderId: String,
    val courier: String,
    val trackNumber: String
){

}