package com.wise.mall.payment.service

import com.wise.mall.payment.model.Payment
import com.wise.mall.payment.model.PaymentStatus
import com.wise.mall.payment.port.`in`.PaymentUseCase
import com.wise.mall.payment.port.`in`.command.CreatePaymentCommand
import com.wise.mall.payment.port.out.PGPaymentClient
import com.wise.mall.payment.port.out.PaymentPersistencePort
import com.wise.mall.payment.port.out.PaymentReadPort
import org.springframework.stereotype.Service

@Service
class PaymentService (
    private val paymentPersistencePort: PaymentPersistencePort,
    private val paymentReadPort : PaymentReadPort,
    private val tossPaymentsClient: PGPaymentClient
) : PaymentUseCase {
    override fun createPayment(command: CreatePaymentCommand) {
        paymentPersistencePort.createPayment(
            Payment(
                paymentCode = command.paymentCode,
                price = command.price,
                method = command.method,
                accountId = command.accountId,
                status = PaymentStatus.fromPgCode(tossPaymentsClient.approvePayment(command.paymentCode)),
                orderId = command.orderId
            )
        )
    }

    override fun getPayment(id: Long): Payment {
        return paymentReadPort.getPaymentById(id)
    }

    override fun getPaymentsByAccountId(accountId: Long): List<Payment> {
        return paymentReadPort.getPaymentsByAccountId(accountId)
    }
}