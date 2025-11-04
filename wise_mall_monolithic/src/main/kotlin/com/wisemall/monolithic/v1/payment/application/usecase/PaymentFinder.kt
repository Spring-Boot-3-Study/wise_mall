package com.wisemall.monolithic.v1.payment.application.usecase

import com.wisemall.monolithic.v1.payment.application.domain.Payment
import com.wisemall.monolithic.v1.payment.persistance.repository.PaymentJpaRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class PaymentFinder (
    private val paymentRepository: PaymentJpaRepository,
) {
    fun getPayment(id: Long): Payment? {
        return paymentRepository.findById(id).getOrNull()?.let {
            Payment(
                id = it.id!!,
                userId = it.userId,
                orderId = it.orderId,
                amount = it.amount,
                status = it.status,
                paymentType = it.paymentType,
                transactionId = it.transactionId,
            )
        }
    }

//    fun getPaymentByOrderId(orderId: Long): Payment?  {
//
//    }
//
//    fun getPayments(userId: Long): List<Payment> {
//
//    }
}