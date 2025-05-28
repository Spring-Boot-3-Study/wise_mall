package com.wise.mall.delivery.service

import com.wise.mall.common.enum.DeliveryStatus
import com.wise.mall.delivery.domain.model.Delivery
import com.wise.mall.delivery.dto.DeliveryToRegisterUpdate
import com.wise.mall.delivery.dto.response.GetDeliveryResponseDto
import com.wise.mall.delivery.dto.response.RegisterDeliveryResponseDto
import com.wise.mall.delivery.port.`in`.command.RegisterDeliveryCommand
import com.wise.mall.delivery.port.`in`.command.UpdateDeliveryStatusCommand
import com.wise.mall.delivery.port.out.DeliveryPersistPort
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime

@ExtendWith(MockitoExtension::class)
class DeliveryServiceTest {

    @Mock
    private lateinit var deliveryPersistPort: DeliveryPersistPort

    private lateinit var deliveryService: DeliveryService

    @BeforeEach
    fun setup() {
        deliveryService = DeliveryService(deliveryPersistPort)
    }

    @Test
    fun shouldRegisterDelivery() {
        // given
        val command = RegisterDeliveryCommand(
            orderId = "ORDER-123",
            courier = "CJ대한통운",
            trackNumber = "1234-5678-9012-3456"
        )
        val delivery = Delivery(
            deliveryId = 1L,
            orderId = command.orderId,
            courier = command.courier,
            trackNumber = command.trackNumber,
            status = DeliveryStatus.READY,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        val deliveryDto = DeliveryToRegisterUpdate(
            deliveryId = 0L,
            orderId = command.orderId,
            courier = command.courier,
            trackNumber = command.trackNumber,
            status = DeliveryStatus.READY,
            createdAt = delivery.createdAt,
            updatedAt = delivery.updatedAt
        )

        `when`(deliveryPersistPort.registerDelivery(any(DeliveryToRegisterUpdate::class.java))).thenReturn(delivery)

        // when
        val result = deliveryService.registerDelivery(command)

        // then
        assert(result.deliveryId == 1L)
        assert(result.courier == command.courier)
        assert(result.trackNumber == command.trackNumber)
        verify(deliveryPersistPort).registerDelivery(any(DeliveryToRegisterUpdate::class.java))
    }

    @Test
    fun shouldGetDelivery() {
        // given
        val deliveryId = 1L
        val delivery = Delivery(
            deliveryId = deliveryId,
            orderId = "ORDER-123",
            courier = "CJ대한통운",
            trackNumber = "1234-5678-9012-3456",
            status = DeliveryStatus.READY,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        `when`(deliveryPersistPort.getDelivery(deliveryId)).thenReturn(delivery)

        // when
        val result = deliveryService.getDelivery(deliveryId)

        // then
        assert(result.deliveryId == deliveryId)
        assert(result.orderId == delivery.orderId)
        assert(result.courier == delivery.courier)
        assert(result.trackNumber == delivery.trackNumber)
        assert(result.status == delivery.status)
        verify(deliveryPersistPort).getDelivery(deliveryId)
    }

    @Test
    fun shouldUpdateDeliveryStatus() {
        // given
        val deliveryId = 1L
        val delivery = Delivery(
            deliveryId = deliveryId,
            orderId = "ORDER-123",
            courier = "CJ대한통운",
            trackNumber = "1234-5678-9012-3456",
            status = DeliveryStatus.READY,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        val command = UpdateDeliveryStatusCommand(
            deliveryId = deliveryId,
            status = DeliveryStatus.SHIPPING
        )

        val updateDto = DeliveryToRegisterUpdate(
            deliveryId = delivery.deliveryId,
            orderId = delivery.orderId,
            courier = delivery.courier,
            trackNumber = delivery.trackNumber,
            status = command.status,
            createdAt = delivery.createdAt,
            updatedAt = delivery.updatedAt
        )

        `when`(deliveryPersistPort.getDelivery(deliveryId)).thenReturn(delivery)
        `when`(deliveryPersistPort.updateDeliveryStatus(any(DeliveryToRegisterUpdate::class.java))).thenReturn(delivery)

        // when
        val result = deliveryService.updateDeliveryStatus(command)

        // then
        assert(result.deliveryId == deliveryId)
        assert(result.courier == delivery.courier)
        assert(result.trackNumber == delivery.trackNumber)
        verify(deliveryPersistPort).getDelivery(deliveryId)
        verify(deliveryPersistPort).updateDeliveryStatus(any(DeliveryToRegisterUpdate::class.java))
    }
} 