package com.wisemall.monolithic.v1.payment.application.application

import com.wisemall.monolithic.v1.payment.application.domain.Payment
import com.wisemall.monolithic.v1.payment.storage.mapper.PaymentEntityMapper
import com.wisemall.monolithic.v1.payment.storage.repository.PaymentJpaRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class PaymentWriter (
    private val paymentRepository: PaymentJpaRepository,
    private val entityMapper: PaymentEntityMapper
) {
    fun init(domain: Payment) : Payment {
        val entity = entityMapper.domainToEntity(domain)
        return entityMapper.entityToDomain(paymentRepository.save(entity))
    }

    @Transactional
    fun update(domain: Payment) {
        val payment = paymentRepository.findById(domain.id!!)
            .orElseThrow { throw IllegalStateException("Payment with id ${domain.id} does not exist") }

        payment.updateTransactionId(domain.transactionId!!)
        payment.updateStatus(domain.status)
    }

}