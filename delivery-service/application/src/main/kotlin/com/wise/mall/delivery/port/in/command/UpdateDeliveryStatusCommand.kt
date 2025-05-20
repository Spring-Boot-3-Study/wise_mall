package com.wise.mall.delivery.port.`in`.command

import com.wise.mall.common.enum.DeliveryStatus


data class UpdateDeliveryStatusCommand(
    val deliveryId: Long,
    val status: DeliveryStatus
)
