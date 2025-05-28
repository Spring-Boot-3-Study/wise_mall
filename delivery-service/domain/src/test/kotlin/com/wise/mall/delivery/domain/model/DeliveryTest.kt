package com.wise.mall.delivery.domain.model

import com.wise.mall.common.enum.DeliveryStatus
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime

class DeliveryTest {

    @Test
    fun shouldChangeStatusFromReadyToShipping() {
        // given
        val delivery = createDelivery(DeliveryStatus.READY)

        // when
        delivery.updateStatus(DeliveryStatus.SHIPPING)

        // then
        assert(delivery.status == DeliveryStatus.SHIPPING)
    }

    @Test
    fun shouldChangeStatusFromReadyToCancelled() {
        // given
        val delivery = createDelivery(DeliveryStatus.READY)

        // when
        delivery.updateStatus(DeliveryStatus.CANCELLED)

        // then
        assert(delivery.status == DeliveryStatus.CANCELLED)
    }

    @Test
    fun shouldChangeStatusFromShippingToCompleted() {
        // given
        val delivery = createDelivery(DeliveryStatus.SHIPPING)

        // when
        delivery.updateStatus(DeliveryStatus.COMPLETED)

        // then
        assert(delivery.status == DeliveryStatus.COMPLETED)
    }

    @Test
    fun shouldChangeStatusFromShippingToReturned() {
        // given
        val delivery = createDelivery(DeliveryStatus.SHIPPING)

        // when
        delivery.updateStatus(DeliveryStatus.RETURNED)

        // then
        assert(delivery.status == DeliveryStatus.RETURNED)
    }

    @Test
    fun shouldThrowExceptionWhenChangingStatusFromReadyToCompleted() {
        // given
        val delivery = createDelivery(DeliveryStatus.READY)

        // when & then
        assertThrows<IllegalStateException> {
            delivery.updateStatus(DeliveryStatus.COMPLETED)
        }
    }

    @Test
    fun shouldThrowExceptionWhenChangingStatusFromCompleted() {
        // given
        val delivery = createDelivery(DeliveryStatus.COMPLETED)

        // when & then
        assertThrows<IllegalStateException> {
            delivery.updateStatus(DeliveryStatus.SHIPPING)
        }
    }

    @Test
    fun shouldChangeStatusToShippingWhenAssigningTrackingNumber() {
        // given
        val delivery = createDelivery(DeliveryStatus.READY)

        // when
        delivery.assignTrackingNumber("1234-5678-9012-3456", "CJ대한통운")

        // then
        assert(delivery.status == DeliveryStatus.SHIPPING)
        assert(delivery.trackNumber == "1234-5678-9012-3456")
        assert(delivery.courier == "CJ대한통운")
    }

    private fun createDelivery(status: DeliveryStatus): Delivery {
        return Delivery(
            deliveryId = 1L,
            orderId = "ORDER-123",
            courier = "CJ대한통운",
            trackNumber = "1234-5678-9012-3456",
            status = status,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    }
} 