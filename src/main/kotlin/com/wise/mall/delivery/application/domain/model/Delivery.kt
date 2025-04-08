package com.wise.mall.delivery.application.domain.model

import java.time.LocalDate
import java.time.LocalDateTime

class Delivery(
    val deliveryId: String,
    val orderId: String,
    private var courier: String?,
    private var trackNumber: String?,
    val createdAt: LocalDateTime,
    private var updatedAt: LocalDateTime,
    private var status: DeliveryStatus = DeliveryStatus.READY
){
    fun updateStatus(newStatus: DeliveryStatus) {
        if (!canTransitionTo(newStatus)) {
            throw IllegalStateException("현재 상태에서 해당 상태로 변경 불가: ${this.status} → $newStatus")
        }
        this.status = newStatus
        this.updatedAt = LocalDateTime.now()
    }

    //상태 변경 제어
    private fun canTransitionTo(newStatus: DeliveryStatus): Boolean {
        return when (status) {
            DeliveryStatus.READY -> newStatus == DeliveryStatus.SHIPPING || newStatus == DeliveryStatus.CANCELLED
            DeliveryStatus.SHIPPING -> newStatus == DeliveryStatus.COMPLETED || newStatus == DeliveryStatus.RETURNED
            DeliveryStatus.COMPLETED, DeliveryStatus.CANCELLED, DeliveryStatus.RETURNED, -> false
        }
    }

    fun assignTrackingNumber(trackingNumber: String) {
        if (this.trackNumber != null) {
            throw IllegalStateException("이미 송장 번호가 등록되어 있습니다")
        }
        this.trackNumber = trackingNumber
        this.updatedAt = LocalDateTime.now()
    }

    fun getStatus(): DeliveryStatus = this.status
    fun getTrackingNumber(): String? = this.trackNumber
    fun getCourier(): String? = this.courier
    fun getUpdatedAt(): LocalDateTime = this.updatedAt
}
