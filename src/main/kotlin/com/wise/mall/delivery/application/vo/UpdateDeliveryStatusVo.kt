package com.wise.mall.delivery.application.vo

import com.wise.mall.delivery.application.domain.model.DeliveryStatus
import java.time.LocalDateTime

data class UpdateDeliveryStatusVo(
    val deliveryId: String,
    val deliveryStatus: DeliveryStatus,
    val updateAt: LocalDateTime
)
