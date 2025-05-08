package com.wise.mall.delivery.port.`in`.command

import com.wise.mall.delivery.application.domain.model.DeliveryStatus
import java.time.LocalDateTime

data class UpdateDeliveryStatusCommand(
    val deliveryId: Long,
    val status: DeliveryStatus
)
