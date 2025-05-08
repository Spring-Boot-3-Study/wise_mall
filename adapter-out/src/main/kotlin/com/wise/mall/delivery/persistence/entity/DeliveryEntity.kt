package com.wise.mall.delivery.persistence.entity

import com.wise.mall.delivery.application.domain.model.DeliveryStatus
import com.wise.mall.global.entity.BaseTimeEntity
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name = "delivery")
@EntityListeners(AuditingEntityListener::class)
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

): BaseTimeEntity()