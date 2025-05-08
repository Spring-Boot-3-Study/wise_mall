package com.wise.mall.delivery.adapter.web.dto.response

data class RegisterDeliveryResponseDto(
    val deliveryId: Long,
    val courier: String,
    val trackNumber: String
)
