package com.wisemall.monolithic.v1.payment.persistance.entity

import com.wisemall.monolithic.v1.global.entity.BaseEntity
import com.wisemall.monolithic.v1.payment.application.enums.PaymentStatus
import com.wisemall.monolithic.v1.payment.application.enums.PaymentType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class PaymentEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val orderId: Long,

    val userId: Long,

    val amount: Double,

    val status: PaymentStatus,

    val paymentType: PaymentType,

    val transactionId: String,

): BaseEntity()