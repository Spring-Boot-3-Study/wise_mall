package com.wise.mall.delivery.adapter.`in`.web.dto.response

import com.wise.mall.delivery.application.domain.model.DeliveryStatus
import java.time.LocalDateTime

data class GetDeliveryResponseDto (
    val deliveryId: String,
    val orderId: String,
    val courier: String?,
    val trackingNumber: String?,
    val status: DeliveryStatus,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)