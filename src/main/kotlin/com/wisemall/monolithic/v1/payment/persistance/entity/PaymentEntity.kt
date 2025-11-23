package com.wisemall.monolithic.v1.payment.persistance.entity

import com.wisemall.monolithic.v1.global.entity.BaseEntity
import com.wisemall.monolithic.v1.payment.application.enums.PaymentStatus
import com.wisemall.monolithic.v1.payment.application.enums.PaymentType
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name = "payment")
@EntityListeners(AuditingEntityListener::class)
class PaymentEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val orderId: Long,

    val accountId: Long,

    val amount: Int,

    @Enumerated(EnumType.STRING)
    var status: PaymentStatus,

    @Enumerated(EnumType.STRING)
    val paymentType: PaymentType,

    var transactionId: String? = null,

): BaseEntity() {

    fun updateTransactionId(transactionId: String) {
        this.transactionId = transactionId
    }

    fun updateStatus(status: PaymentStatus) {
        this.status = status
    }
}