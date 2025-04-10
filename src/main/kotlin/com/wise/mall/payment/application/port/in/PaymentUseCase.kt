package com.wise.mall.payment.application.port.`in`

import com.wise.mall.payment.application.domain.model.Payment
import com.wise.mall.payment.application.port.`in`.command.CreatePaymentCommand

interface PaymentUseCase {
    fun createPayment(command : CreatePaymentCommand)
    fun getPayment(id : Long) : Payment
}