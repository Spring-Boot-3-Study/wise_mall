package com.wise.mall.payment.service

import com.wise.mall.payment.dto.PaymentDto
import com.wise.mall.payment.model.Payment
import com.wise.mall.payment.model.PaymentStatus
import com.wise.mall.payment.port.`in`.PaymentUseCase
import com.wise.mall.payment.port.`in`.command.ApprovePaymentCommand
import com.wise.mall.payment.port.`in`.command.CreatePaymentCommand
import com.wise.mall.payment.port.out.PGPaymentClient
import com.wise.mall.payment.port.out.PaymentPersistencePort
import com.wise.mall.payment.port.out.PaymentReadPort
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PaymentService (
    private val paymentPersistencePort: PaymentPersistencePort,
    private val paymentReadPort : PaymentReadPort,
    private val pgPaymentClient: PGPaymentClient
) : PaymentUseCase {
    override fun createPayment(command: CreatePaymentCommand) {
        paymentPersistencePort.createPayment(
            Payment(
                paymentCode = command.paymentCode,
                price = command.price,
                method = command.method,
                accountId = command.accountId,
                // 최초 결제정보 생성시 결제 대기상태로 생성
                status = PaymentStatus.PENDING,
                orderId = command.orderId
            )
        )
    }

    override fun getPayment(id: Long): PaymentDto {
        val payment = paymentReadPort.getPaymentById(id)
        return toPaymentDto(payment)
    }

    override fun getPaymentsByAccountId(accountId: Long): List<PaymentDto> {
        val payments = paymentReadPort.getPaymentsByAccountId(accountId)
        return payments.map { toPaymentDto(it) }
    }

    override fun approvePayment(command: ApprovePaymentCommand) {

        paymentPersistencePort.updatePayment(command.paymentId,
            pgPaymentClient.approvePayment(command.tid, command.pgToken),command.tid)
    }

    private fun toPaymentDto(payment: Payment): PaymentDto {
        return PaymentDto(
            id = payment.id,
            orderId = payment.orderId,
            accountId = payment.accountId,
            paymentCode = payment.paymentCode,
            price = payment.price,
            status = payment.status.toString(),
            method = payment.method,
            createdAt = payment.createdAt
        )
    }
}
