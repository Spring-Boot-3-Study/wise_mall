package com.wise.mall.payment.web

import com.wise.mall.common.response.ResponseDto
import com.wise.mall.payment.port.`in`.PaymentUseCase
import com.wise.mall.payment.port.`in`.command.ApprovePaymentCommand
import com.wise.mall.payment.port.`in`.command.CreatePaymentCommand
import com.wise.mall.payment.web.dto.request.ApprovePaymentRequestDto
import com.wise.mall.payment.web.dto.request.CreatePaymentRequestDto
import com.wise.mall.payment.web.dto.response.GetPaymentResponseDto
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
            price = createPaymentRequest.price
        )
        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(PaymentAdapterResponse.PAYMENT_CREATE_PAYMENT_SUCCESS.toResponseDto())
    }
    @PostMapping
    fun approvePayment(@RequestBody approvePaymentRequest : ApprovePaymentRequestDto) : ResponseEntity<ResponseDto<Map<String, Any>>>{
        paymentUseCase.approvePayment(command= ApprovePaymentCommand(
            orderId = approvePaymentRequest.orderId,
            accountId = approvePaymentRequest.accountId,
            paymentCode = approvePaymentRequest.paymentCode,
            method = approvePaymentRequest.method,
            price = approvePaymentRequest.price
        )
        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(PaymentAdapterResponse.PAYMENT_CREATE_PAYMENT_SUCCESS.toResponseDto())
    }
    @GetMapping("/{id}")
    fun getPayment(@PathVariable id: Long) : ResponseEntity<ResponseDto<GetPaymentResponseDto>> {
        val paymentDto = paymentUseCase.getPayment(id)
        val getPaymentResponseDto = GetPaymentResponseDto(
            paymentId = paymentDto.id,
            orderId = paymentDto.orderId,
            paymentCode = paymentDto.paymentCode,
            method = paymentDto.method,
            status = paymentDto.status,
            createdAt = paymentDto.createdAt,
        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(PaymentAdapterResponse.PAYMENT_GET_DETAIL_PAYMENT_SUCCESS.toResponseDto(getPaymentResponseDto))
    }

    @GetMapping("/account/{accountId}")
    fun getPaymentsByAccount(@PathVariable accountId: Long) : ResponseEntity<ResponseDto<List<GetPaymentResponseDto>>> {
        val paymentDtos = paymentUseCase.getPaymentsByAccountId(accountId)
        val paymentResponseDtoList = paymentDtos.map { paymentDto ->
            GetPaymentResponseDto(
                paymentId = paymentDto.id,
                orderId = paymentDto.orderId,
                paymentCode = paymentDto.paymentCode,
                method = paymentDto.method,
                status = paymentDto.status,
                createdAt = paymentDto.createdAt
            )
        }
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(PaymentAdapterResponse.PAYMENT_GET_ACCOUNT_PAYMENTS_SUCCESS.toResponseDto(paymentResponseDtoList))
    }
}
