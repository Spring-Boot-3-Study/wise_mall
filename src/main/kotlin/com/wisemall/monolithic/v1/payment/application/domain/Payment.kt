package com.wisemall.monolithic.v1.payment.application.domain

import com.wisemall.monolithic.v1.payment.application.enums.PaymentStatus
import com.wisemall.monolithic.v1.payment.application.enums.PaymentType

class Payment (
    val accountId: Long,
    val orderId: Long,
    val amount: Int,
    status: PaymentStatus,
    val paymentType: PaymentType,
    id: Long? = null,
    transactionId: String? = null
) {
    companion object {
        fun create(
            accountId: Long,
            orderId: Long,
            amount: Int,
            paymentType: PaymentType
        ): Payment {
            return Payment(
                accountId = accountId,
                orderId = orderId,
                amount = amount,
                status = PaymentStatus.PENDING,
                paymentType = paymentType
            )
        }
    }

    var id: Long? = null
        private set

    var status: PaymentStatus = status
        private set

    var transactionId: String? = null
        private set

    fun updateId(id: Long) {
        this.id = id
    }

    fun updateTransactionId(transactionId: String) {
        this.transactionId = transactionId
    }

}