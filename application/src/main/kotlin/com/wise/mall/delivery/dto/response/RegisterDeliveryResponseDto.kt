package com.wise.mall.delivery.dto.response

data class RegisterDeliveryResponseDto(
    val deliveryId: Long,
    val courier: String,
    val trackNumber: String
)
