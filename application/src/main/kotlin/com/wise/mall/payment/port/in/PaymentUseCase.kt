package com.wise.mall.payment.port.`in`

import com.wise.mall.payment.dto.PaymentDto
import com.wise.mall.payment.port.`in`.command.CreatePaymentCommand

interface PaymentUseCase {
    fun createPayment(command : CreatePaymentCommand)
    fun getPayment(id : Long) : PaymentDto
    fun getPaymentsByAccountId(accountId : Long) : List<PaymentDto>
}
