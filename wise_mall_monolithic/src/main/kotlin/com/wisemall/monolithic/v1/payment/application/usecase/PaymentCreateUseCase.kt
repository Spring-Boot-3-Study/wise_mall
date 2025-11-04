package com.wisemall.monolithic.v1.payment.application.usecase

import com.wisemall.monolithic.v1.payment.persistance.repository.PaymentJpaRepository
import org.springframework.stereotype.Service

@Service
class PaymentCreateUseCase(
    private val paymentRepository: PaymentJpaRepository,
)  {
}