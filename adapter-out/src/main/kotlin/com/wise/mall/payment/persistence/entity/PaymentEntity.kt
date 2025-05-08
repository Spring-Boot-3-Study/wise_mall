package com.wise.mall.payment.persistence.entity


import com.wise.mall.payment.application.domain.model.Payment
import com.wise.mall.payment.application.domain.model.PaymentStatus
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name = "payment")
@EntityListeners(AuditingEntityListener::class)
class PaymentEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="paymentId")
    val paymentId : Long? = null,

    @Column(name="paymentCode")
    var paymentCode : String,

    @Column(name="price")
    var price : Int,

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    var status : PaymentStatus,

    @Column(name="method")
    var method : String,

    @Column(name="orderId")
    var orderId : Long,

    @Column(name="accountId")
    var accountId : Long,
) {
    fun toDomain(): Payment {
        return Payment(
            id = this.paymentId,
            paymentCode = this.paymentCode,
            price = this.price,
            status = this.status,
            method = this.method,
            orderId = this.orderId,
            accountId = this.accountId
        )
    }

    companion object {
        fun from(domain: Payment): PaymentEntity {
            return PaymentEntity(
                paymentId = domain.id,
                paymentCode = domain.paymentCode,
                price = domain.price,
                status = domain.status,
                method = domain.method,
                orderId = domain.orderId,
                accountId = domain.accountId
            )
        }
    }
}
