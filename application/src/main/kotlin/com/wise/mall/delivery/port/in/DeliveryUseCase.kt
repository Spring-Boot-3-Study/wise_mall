package com.wise.mall.delivery.port.`in`

interface DeliveryUseCase {
    fun registerDelivery(command: RegisterDeliveryCommand) : RegisterDeliveryResponseDto
    fun getDelivery(deliveryId: Long): GetDeliveryResponseDto
    fun updateDeliveryStatus(command: UpdateDeliveryStatusCommand) : RegisterDeliveryResponseDto
}