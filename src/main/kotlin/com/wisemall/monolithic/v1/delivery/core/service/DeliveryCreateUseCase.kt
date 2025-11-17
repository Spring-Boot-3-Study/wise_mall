package com.wisemall.monolithic.v1.delivery.core.service

import com.wisemall.monolithic.v1.delivery.storage.entity.DeliveryEntity
import com.wisemall.monolithic.v1.delivery.storage.repository.DeliveryRepository
import com.wisemall.monolithic.v1.global.enums.OrderStatus
import com.wisemall.monolithic.v1.order.core.exception.OrderNotFoundException
import com.wisemall.monolithic.v1.order.storage.repository.OrderRepository
import com.wisemall.monolithic.v1.payment.application.exception.OrderInvalidException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DeliveryCreateUseCase(
    private val orderRepository: OrderRepository,
    private val deliveryRepository: DeliveryRepository
) {

    @Transactional
    fun execute(
        orderId: Long,
        carrier: String,
        trackNumber: String
    ) {
        val order = orderRepository.findById(orderId).orElseThrow { throw OrderNotFoundException(orderId) }
        check(order.status == OrderStatus.PROCESSING) { throw OrderInvalidException() }
        val delivery = deliveryRepository.save(
            DeliveryEntity(
                orderId = orderId,
                carrier = carrier,
                trackNumber = trackNumber,
                shippingDate = LocalDateTime.now()
            )
        )
    }
}