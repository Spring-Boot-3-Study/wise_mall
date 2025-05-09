package com.wise.mall.payment.persistence

import com.wise.mall.payment.model.Payment
import com.wise.mall.payment.persistence.repository.PaymentRepository
import com.wise.mall.payment.port.out.PaymentReadPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class PaymentReadAdapter(
    private val paymentRepository: PaymentRepository
) : PaymentReadPort {

    @Transactional
    override fun getPaymentById(paymentId: Long): Payment {
        return paymentRepository.findById(paymentId).get().toDomain()
    }

    @Transactional
    override fun getPaymentsByAccountId(accountId: Long): List<Payment> {
        return paymentRepository.findAllByAccountId(accountId)
            .map { it.toDomain() }
    }
}