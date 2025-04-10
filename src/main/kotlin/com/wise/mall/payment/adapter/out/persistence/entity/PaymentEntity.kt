package com.wise.mall.payment.adapter.out.persistence.entity


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

    @Column(name="status")
    var status : Char,

    @Column(name="method")
    var method : String,

    @Column(name="orderId")
    var orderId : Long,

    @Column(name="accountId")
    var accountId : Long,
)
