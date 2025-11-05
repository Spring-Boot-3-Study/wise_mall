package com.wisemall.monolithic.v1.payment.application.service

import com.wisemall.monolithic.v1.payment.application.application.PaymentGateway
import org.springframework.stereotype.Service

@Service
class ExternalPgHandler(
    private val paymentGateway: PaymentGateway
) {

    fun success() {
//        paymentGateway.
    }
}