package com.wise.mall.delivery.port.`in`.command

import com.wise.mall.common.enums.DeliveryStatus


data class UpdateDeliveryStatusCommand(
    val deliveryId: Long,
    val status: DeliveryStatus
)
