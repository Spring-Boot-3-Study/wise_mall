package com.wise.mall.delivery.domain.model

import com.wise.mall.common.enum.DeliveryStatus
import java.time.LocalDateTime


class Delivery(
    val deliveryId: Long,

    val orderId: String,

    var courier: String,

    var trackNumber: String,

    val createdAt: LocalDateTime,

    var updatedAt: LocalDateTime,

    var status: DeliveryStatus = DeliveryStatus.READY
){
    fun updateStatus(newStatus: DeliveryStatus) {
        if (!canTransitionTo(newStatus)) {
            throw IllegalStateException("현재 상태에서 해당 상태로 변경 불가: ${this.status} → $newStatus")
        }
        status = newStatus
        updatedAt = LocalDateTime.now()
    }

    //상태 변경 제어
    private fun canTransitionTo(newStatus: DeliveryStatus): Boolean {
        return when (status) {
            DeliveryStatus.READY -> newStatus == DeliveryStatus.SHIPPING || newStatus == DeliveryStatus.CANCELLED
            DeliveryStatus.SHIPPING -> newStatus == DeliveryStatus.COMPLETED || newStatus == DeliveryStatus.RETURNED
            DeliveryStatus.COMPLETED, DeliveryStatus.CANCELLED, DeliveryStatus.RETURNED -> false
        }
    }
    
    /*택배 접수 분리시 사용*/
    fun assignTrackingNumber(trackingNumber: String, courier: String) {
        this.courier = courier
        this.trackNumber = trackingNumber
        updateStatus(DeliveryStatus.SHIPPING)
    }

}
