package com.wisemall.monolithic.v1.delivery.storage.entity

import com.wisemall.monolithic.v1.global.entity.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "delivery")
class DeliveryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val orderId: Long,

    val carrier: String,

    val trackNumber: String,

    val shippingDate: LocalDateTime,

): BaseEntity() {
}