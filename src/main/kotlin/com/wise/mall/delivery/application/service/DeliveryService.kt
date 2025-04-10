package com.wise.mall.delivery.application.service

import com.wise.mall.delivery.application.domain.model.Delivery
import com.wise.mall.delivery.application.domain.model.DeliveryStatus
import com.wise.mall.delivery.application.port.`in`.DeliveryUseCase
import com.wise.mall.delivery.application.port.`in`.command.RegisterDeliveryCommand
import com.wise.mall.delivery.application.port.`in`.command.UpdateDeliveryStatusCommand
import com.wise.mall.delivery.application.port.out.DeliveryPersistPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DeliveryService(private val deliveryPersistPort: DeliveryPersistPort) : DeliveryUseCase {

    @Transactional
    override fun registerDelivery(command: RegisterDeliveryCommand) {
        deliveryPersistPort.registerDelivery(Delivery(
            deliveryId = 0L,
            orderId = command.orderId,
            courier = command.courier,
            trackNumber = command.trackNumber,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
            status = DeliveryStatus.READY
            )
        )
    }

    @Transactional
    override fun getDelivery(deliveryId: Long): Delivery {
        return deliveryPersistPort.getDelivery(deliveryId)
    }

    @Transactional
    override fun updateDeliveryStatus(command: UpdateDeliveryStatusCommand) {
        val delivery = getDelivery(command.deliveryId)
        delivery.updateStatus(command.status)
    }
}