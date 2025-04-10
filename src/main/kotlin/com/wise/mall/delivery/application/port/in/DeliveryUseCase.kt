package com.wise.mall.delivery.application.port.`in`

import com.wise.mall.delivery.application.domain.model.Delivery
import com.wise.mall.delivery.application.port.`in`.command.RegisterDeliveryCommand
import com.wise.mall.delivery.application.port.`in`.command.UpdateDeliveryStatusCommand

interface DeliveryUseCase {
    fun registerDelivery(command: RegisterDeliveryCommand)
    fun getDelivery(deliveryId: Long): Delivery
    fun updateDeliveryStatus(command: UpdateDeliveryStatusCommand)
}
