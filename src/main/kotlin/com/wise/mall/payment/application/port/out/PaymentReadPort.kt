package com.wise.mall.payment.application.port.out

import com.wise.mall.global.response.ResponseDto
import com.wise.mall.payment.adapter.`in`.web.dto.response.GetPaymentResponseDto
import com.wise.mall.payment.application.domain.model.Payment
import org.springframework.http.ResponseEntity

interface PaymentReadPort {
    fun getPaymentById(paymentId : Long) : Payment
    fun getPaymentsByAccountId(accountId : Long) : List<Payment>
}