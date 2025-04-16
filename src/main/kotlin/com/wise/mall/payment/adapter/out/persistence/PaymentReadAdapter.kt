package com.wise.mall.payment.adapter.out.persistence

import com.wise.mall.payment.adapter.out.persistence.repository.PaymentRepository
import com.wise.mall.payment.application.domain.model.Payment
import com.wise.mall.payment.application.port.out.PaymentReadPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class PaymentReadAdapter(
    private val paymentRepository: PaymentRepository
) : PaymentReadPort{

    @Transactional
    override fun getPaymentById(paymentId: Long): Payment{
        return paymentRepository.findById(paymentId)
            .map{ it.toDomain() }
            .orElse(null)
    }

    @Transactional
    override fun getPaymentsByAccountId(accountId: Long): List<Payment> {
        return paymentRepository.findAllByAccountId(accountId)
            .map { it.toDomain() }
    }
}