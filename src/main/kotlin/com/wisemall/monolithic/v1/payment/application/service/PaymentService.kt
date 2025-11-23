package com.wisemall.monolithic.v1.payment.application.service

import com.wisemall.monolithic.v1.payment.application.domain.Payment
import com.wisemall.monolithic.v1.payment.application.enums.PaymentType
import com.wisemall.monolithic.v1.payment.application.application.PaymentValidator
import com.wisemall.monolithic.v1.payment.application.application.PaymentFinder
import com.wisemall.monolithic.v1.payment.application.application.PaymentWriter
import com.wisemall.monolithic.v1.payment.application.application.PaymentGateway
import com.wisemall.monolithic.v1.payment.application.enums.PaymentStatus
import com.wisemall.monolithic.v1.payment.application.exception.PgFailException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service


private val log = KotlinLogging.logger {}

@Service
class PaymentService(
    private val paymentFinder: PaymentFinder,
    private val paymentWriter: PaymentWriter,
    private val orderValidator: PaymentValidator,
    private val paymentGateway: PaymentGateway,
) {

    fun requestPayment (
        orderId: Long,
        accountId: Long,
        paymentType: PaymentType,
        amount: Int,
    ): Payment {
        // 주문 검증
        orderValidator.valid(orderId, accountId, amount)

        // 새로운 결제 생성
        val newPayment = Payment.create(accountId, orderId, amount, paymentType)
        paymentWriter.init(newPayment)
            .also{ newPayment.updateId(it.id!!) }

        // 외부 PG API 요청
        try {
            val response = paymentGateway.transfer(newPayment)
            newPayment.updateTransactionId(response.transactionId)
        } catch (e: PgFailException) {
            log.error { "Payment gateway failed ${e.message}" }
            // 결제 실패 핸들링
            paymentWriter.update(newPayment)
        }
        // 상태 업데이트
        paymentWriter.update(newPayment)

        return newPayment
    }

    fun getPayment(orderId: Long): Payment? {
        return paymentFinder.getPaymentByOrderId(orderId)
    }

    fun getUserPaymentHistory(accountId: Long): List<Payment> {
        return paymentFinder.getPaymentsByAccountId(accountId)
    }

}