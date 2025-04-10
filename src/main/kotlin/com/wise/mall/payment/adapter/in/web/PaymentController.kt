package com.wise.mall.payment.adapter.`in`.web

import com.wise.mall.global.response.ResponseDto
import com.wise.mall.payment.adapter.`in`.web.dto.request.CreatePaymentRequestDto
import com.wise.mall.payment.application.port.`in`.PaymentUseCase
import com.wise.mall.payment.application.port.`in`.command.CreatePaymentCommand
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * Payment RestController
 */
@RestController
class PaymentController(
    private val paymentUseCase: PaymentUseCase
) {

    @PostMapping
    fun createPayment(@RequestBody createPaymentRequest : CreatePaymentRequestDto) : ResponseEntity<ResponseDto<Map<String, Any>>> {
        paymentUseCase.createPayment(command= CreatePaymentCommand(
            orderId = createPaymentRequest.orderId,
            accountId = createPaymentRequest.accountId,
            paymentCode = createPaymentRequest.paymentCode,
            method = createPaymentRequest.method,
            price =  createPaymentRequest.price
        ))

        return ResponseEntity.ok().build()
    }
}