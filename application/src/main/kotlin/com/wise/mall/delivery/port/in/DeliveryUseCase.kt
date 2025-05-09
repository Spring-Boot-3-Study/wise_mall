package com.wise.mall.delivery.port.`in`

import com.wise.mall.delivery.dto.response.GetDeliveryResponseDto
import com.wise.mall.delivery.dto.response.RegisterDeliveryResponseDto
import com.wise.mall.delivery.port.`in`.command.RegisterDeliveryCommand
import com.wise.mall.delivery.port.`in`.command.UpdateDeliveryStatusCommand

interface DeliveryUseCase {
    fun registerDelivery(command: RegisterDeliveryCommand) : RegisterDeliveryResponseDto
    fun getDelivery(deliveryId: Long): GetDeliveryResponseDto
    fun updateDeliveryStatus(command: UpdateDeliveryStatusCommand) : RegisterDeliveryResponseDto
}