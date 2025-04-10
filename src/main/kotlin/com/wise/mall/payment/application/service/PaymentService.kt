package com.wise.mall.payment.application.service

import com.wise.mall.payment.application.domain.model.Payment
import com.wise.mall.payment.application.port.`in`.PaymentUseCase
import com.wise.mall.payment.application.port.`in`.command.CreatePaymentCommand
import com.wise.mall.payment.application.port.out.PaymentPersistencePort
import org.springframework.stereotype.Service

@Service
class PaymentService (
    private val paymentPersistencePort: PaymentPersistencePort
) : PaymentUseCase {
    override fun createPayment(command: CreatePaymentCommand) {
        paymentPersistencePort.createPayment(Payment(
            paymentCode = command.paymentCode,
            price = command.price,
            status = command.status,
            method = command.method,
            accountId = command.accountId,
            orderId = command.orderId
        ))
    }

    override fun getPayment(id: Long): Payment {
        TODO("Not yet implemented")
    }
}