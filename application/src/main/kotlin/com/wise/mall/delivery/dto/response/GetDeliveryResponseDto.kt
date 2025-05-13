package com.wise.mall.delivery.dto.response

import com.wise.mall.common.enum.DeliveryStatus
import java.time.LocalDateTime

data class GetDeliveryResponseDto (
    val deliveryId: Long,
    val orderId: String,
    val courier: String,
    val trackNumber: String,
    val status: DeliveryStatus,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)