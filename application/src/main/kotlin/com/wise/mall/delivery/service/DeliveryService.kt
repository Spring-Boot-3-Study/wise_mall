package com.wise.mall.delivery.service

import java.time.LocalDateTime

@Service
class DeliveryService(private val deliveryPersistPort: DeliveryPersistPort) : DeliveryUseCase {

    @Transactional
    override fun registerDelivery(command: RegisterDeliveryCommand): RegisterDeliveryResponseDto {
        val deliveryDto = DeliveryToRegisterUpdate(
            deliveryId = 0L,
            orderId = command.orderId,
            courier = command.courier,
            trackNumber = command.trackNumber,
            status = DeliveryStatus.READY,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
        val delivery =  deliveryPersistPort.registerDelivery(deliveryDto)

        return RegisterDeliveryResponseDto(
            deliveryId = delivery.deliveryId,
            courier = delivery.courier,
            trackNumber = delivery.trackNumber
        )
    }

    @Transactional
    override fun getDelivery(deliveryId: Long): GetDeliveryResponseDto {
        val delivery = deliveryPersistPort.getDelivery(deliveryId)
        return GetDeliveryResponseDto(
            deliveryId = delivery.deliveryId,
            orderId = delivery.orderId,
            courier = delivery.courier,
            trackNumber = delivery.trackNumber,
            createdAt = delivery.createdAt,
            updatedAt = delivery.updatedAt,
            status = delivery.status
        )
    }

    @Transactional
    override fun updateDeliveryStatus(command: UpdateDeliveryStatusCommand): RegisterDeliveryResponseDto {
        val delivery = deliveryPersistPort.getDelivery(command.deliveryId)

        val updateDto = DeliveryToRegisterUpdate(
            deliveryId = delivery.deliveryId,
            orderId = delivery.orderId,
            status = command.status,
            courier = delivery.courier,
            trackNumber = delivery.trackNumber,
            createdAt = delivery.createdAt,
            updatedAt = delivery.updatedAt,
            )
        val updatedDelivery = deliveryPersistPort.updateDeliveryStatus(updateDto)

        return RegisterDeliveryResponseDto(
            deliveryId = updatedDelivery.deliveryId,
            courier = updatedDelivery.courier,
            trackNumber = updatedDelivery.trackNumber,
        )
    }
}