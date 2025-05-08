package com.wise.mall.payment.port.`in`

import com.wise.mall.payment.application.domain.model.Payment
import com.wise.mall.payment.model.Payment
import com.wise.mall.payment.port.`in`.command.CreatePaymentCommand

interface PaymentUseCase {
    fun createPayment(command : CreatePaymentCommand)
    fun getPayment(id : Long) : Payment
    fun getPaymentsByAccountId(accountId : Long) : List<Payment>
}