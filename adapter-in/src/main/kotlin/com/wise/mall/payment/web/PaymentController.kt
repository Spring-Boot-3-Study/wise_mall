package com.wise.mall.payment.web

import com.wise.mall.global.response.ResponseDto
import com.wise.mall.payment.web.dto.request.CreatePaymentRequestDto
import com.wise.mall.payment.web.dto.response.GetPaymentResponseDto
import com.wise.mall.payment.application.domain.model.Payment
import com.wise.mall.payment.application.port.`in`.PaymentUseCase
import com.wise.mall.payment.application.port.`in`.command.CreatePaymentCommand
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.*

/**
 * Payment RestController
 */
@RestController
@RequestMapping("/payment")
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

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(PaymentAdapterResponse.PAYMENT_CREATE_PAYMENT_SUCCESS.toResponseDto())
    }

    @GetMapping("/{id}")
    fun getPayment(@PathVariable id: Long) : ResponseEntity<ResponseDto<GetPaymentResponseDto>> {
        val payment = paymentUseCase.getPayment(id)
        val getPaymentResponseDto = GetPaymentResponseDto(

            paymentId = payment.id,
            orderId = payment.orderId,
            paymentCode = payment.paymentCode,
            method = payment.method,
            status = payment.status.toString(),
            createdAt = payment.createdAt,

        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(PaymentAdapterResponse.PAYMENT_GET_DETAIL_PAYMENT_SUCCESS.toResponseDto(getPaymentResponseDto))
    }

    @GetMapping("/account/{accountId}")
    fun getPaymentsByAccount(@PathVariable accountId: Long) : ResponseEntity<ResponseDto<List<GetPaymentResponseDto>>> {
        val payments : List<Payment> = paymentUseCase.getPaymentsByAccountId(accountId)
        val paymentResponseDtoList : List<GetPaymentResponseDto> = payments.map{ payment: Payment ->
            GetPaymentResponseDto(
                paymentId = payment.id,
                orderId = payment.orderId,
                paymentCode = payment.paymentCode,
                method = payment.method,
                status = payment.status.toString(),
                createdAt = payment.createdAt
            )
        }
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(PaymentAdapterResponse.PAYMENT_GET_ACCOUNT_PAYMENTS_SUCCESS.toResponseDto(paymentResponseDtoList))

    }
}