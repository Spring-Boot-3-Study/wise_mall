package com.wise.mall.payment.persistence

import com.wise.mall.payment.persistence.entity.PaymentEntity
import com.wise.mall.payment.persistence.repository.PaymentRepository
import com.wise.mall.payment.application.domain.model.Payment
import com.wise.mall.payment.application.port.out.PaymentPersistencePort
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class PaymentPersistenceAdapter (
    private val paymentRepository : PaymentRepository
): PaymentPersistencePort{

    @Transactional
    override fun createPayment(payment: Payment) {
        paymentRepository.save(PaymentEntity(
            paymentCode = payment.paymentCode,
            price = payment.price,
            orderId = payment.orderId,
            method = payment.method,
            accountId = payment.accountId,
            status = payment.status
        ))
    }
}