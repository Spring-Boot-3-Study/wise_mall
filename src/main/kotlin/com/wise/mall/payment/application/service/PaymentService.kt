package com.wise.mall.payment.application.service

import com.wise.mall.payment.adapter.out.pg.TossPaymentsClient
import com.wise.mall.payment.application.domain.model.Payment
import com.wise.mall.payment.application.domain.model.PaymentStatus
import com.wise.mall.payment.application.port.`in`.PaymentUseCase
import com.wise.mall.payment.application.port.`in`.command.CreatePaymentCommand
import com.wise.mall.payment.application.port.out.PGPaymentClient
import com.wise.mall.payment.application.port.out.PaymentPersistencePort
import com.wise.mall.payment.application.port.out.PaymentReadPort
import org.springframework.stereotype.Service

@Service
class PaymentService (
    private val paymentPersistencePort: PaymentPersistencePort,
    private val paymentReadPort : PaymentReadPort,
    private val tossPaymentsClient: PGPaymentClient
) : PaymentUseCase {
    override fun createPayment(command: CreatePaymentCommand) {
        paymentPersistencePort.createPayment(Payment(
            paymentCode = command.paymentCode,
            price = command.price,
            method = command.method,
            accountId = command.accountId,
            status = PaymentStatus.fromPgCode(tossPaymentsClient.approvePayment(command.paymentCode)),
            orderId = command.orderId
        ))
    }

    override fun getPayment(id: Long): Payment {
        return paymentReadPort.getPaymentById(id)
    }

    override fun getPaymentsByAccountId(accountId: Long): List<Payment> {
        return paymentReadPort.getPaymentsByAccountId(accountId)
    }
}