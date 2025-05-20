package com.wise.mall.delivery.dto

import com.wise.mall.common.enum.DeliveryStatus
import java.time.LocalDateTime

data class DeliveryToRegisterUpdate(
    val deliveryId: Long,
    val orderId: String,
    val courier: String,
    val trackNumber: String,
    val status: DeliveryStatus,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) 