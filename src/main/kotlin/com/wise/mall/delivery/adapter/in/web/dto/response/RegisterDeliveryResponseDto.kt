package com.wise.mall.delivery.adapter.`in`.web.dto.response

data class RegisterDeliveryResponseDto(
    val deliveryId: Long,
    val courier: String,
    val trackNumber: String
)
