package com.wisemall.monolithic.v1.payment.persistance.mapper

import com.wisemall.monolithic.v1.payment.application.domain.Payment
import com.wisemall.monolithic.v1.payment.persistance.entity.PaymentEntity
import org.springframework.stereotype.Component

@Component
class PaymentEntityMapper {
    fun domainToEntity(
        domain: Payment
    ): PaymentEntity {
        return PaymentEntity(
            id = domain.id,
            accountId = domain.accountId,
            orderId = domain.orderId,
            amount = domain.amount,
            status = domain.status,
            paymentType = domain.paymentType,
            transactionId = domain.transactionId,
        )
    }

    fun entityToDomain(
        entity: PaymentEntity
    ) : Payment {
        return Payment(
            id = entity.id!!,
            accountId = entity.accountId,
            orderId = entity.orderId,
            amount = entity.amount,
            status = entity.status,
            paymentType = entity.paymentType,
            transactionId = entity.transactionId,
        )
    }
}