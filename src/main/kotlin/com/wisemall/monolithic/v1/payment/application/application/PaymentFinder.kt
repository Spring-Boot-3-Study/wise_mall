package com.wisemall.monolithic.v1.payment.application.application

import com.wisemall.monolithic.v1.payment.application.domain.Payment
import com.wisemall.monolithic.v1.payment.persistance.mapper.PaymentEntityMapper
import com.wisemall.monolithic.v1.payment.persistance.repository.PaymentJpaRepository
import org.springframework.stereotype.Service

@Service
class PaymentFinder (
    private val paymentRepository: PaymentJpaRepository,
    private val entityMapper: PaymentEntityMapper
) {

    fun getPaymentByOrderId(orderId: Long): Payment?  {
        return entityMapper.entityToDomain(paymentRepository.findByOrderId(orderId))
    }

    fun getPaymentsByAccountId(accountId: Long): List<Payment> {
        return paymentRepository.findByaccountId(accountId)
            .map {
                entityMapper.entityToDomain(it)
            }
    }
}