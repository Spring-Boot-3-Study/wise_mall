package com.wise.mall.delivery.application.port.`in`

import com.wise.mall.delivery.adapter.`in`.web.dto.response.GetDeliveryResponseDto
import com.wise.mall.delivery.adapter.`in`.web.dto.response.RegisterDeliveryResponseDto
import com.wise.mall.delivery.application.domain.model.Delivery
import com.wise.mall.delivery.application.port.`in`.command.RegisterDeliveryCommand
import com.wise.mall.delivery.application.port.`in`.command.UpdateDeliveryStatusCommand

interface DeliveryUseCase {
    fun registerDelivery(command: RegisterDeliveryCommand) : RegisterDeliveryResponseDto
    fun getDelivery(deliveryId: Long): GetDeliveryResponseDto
    fun updateDeliveryStatus(command: UpdateDeliveryStatusCommand) : RegisterDeliveryResponseDto
}
