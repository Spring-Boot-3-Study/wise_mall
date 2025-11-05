package com.wisemall.monolithic.v1.payment.api

import com.wisemall.monolithic.v1.payment.api.dto.PaymentRequest
import com.wisemall.monolithic.v1.payment.api.dto.PaymentResponse
import com.wisemall.monolithic.v1.payment.application.enums.PaymentStatus
import com.wisemall.monolithic.v1.payment.application.service.PaymentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/payment")
class PaymentController(
    private val paymentService: PaymentService
) {
    @PostMapping("")
    fun requestPayment(
        request: PaymentRequest
    ): ResponseEntity<PaymentResponse> {
        paymentService.requestPayment(
            request.orderId,
            request.accountId,
            request.paymentType,
            request.amount
        ).run {
            return when (this.status) {
                PaymentStatus.PENDING ->
                    ResponseEntity.internalServerError().body(null)
                PaymentStatus.FAILED ->
                    ResponseEntity.badRequest().body(null)
                PaymentStatus.SUCCESS ->
                    ResponseEntity
                        .status(if(this.status.toString() == "SUCCESS") 200 else 400)
                        .body(PaymentResponse(
                            orderId = this.orderId,
                            amount = this.amount,
                            status = this.status.toString()
                        ))
            }
        }

    }

    @GetMapping("/order/{orderId}")
    fun getPayment(@PathVariable orderId: Long): ResponseEntity<PaymentResponse> {
        return paymentService.getPayment(orderId)
            ?. let { ResponseEntity.ok(PaymentResponse(
                orderId = it.orderId,
                amount = it.amount,
                status = it.status.toString()
            ))}
            ?: ResponseEntity.notFound().build()
    }

}