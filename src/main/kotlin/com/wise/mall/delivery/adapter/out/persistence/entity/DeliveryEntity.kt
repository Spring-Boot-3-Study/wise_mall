package com.wise.mall.delivery.adapter.out.persistence.entity

import com.wise.mall.delivery.application.domain.model.Delivery
import com.wise.mall.delivery.application.domain.model.DeliveryStatus
import com.wise.mall.global.entity.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "delivery")
class DeliveryEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val deliveryId: Long,

    @Column(name = "orderId", nullable = false)
    val orderId: String,

    @Column(name = "courier")
    var courier: String,

    @Column(name = "trackNumber")
    var trackNumber: String,

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    var status: DeliveryStatus,

): BaseTimeEntity() {

    fun toDomain(): Delivery {
        return Delivery(
            deliveryId = this.deliveryId,
            orderId = this.orderId,
            courier = this.courier,
            trackNumber = this.trackNumber,
            status = this.status,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt
        )
    }
}