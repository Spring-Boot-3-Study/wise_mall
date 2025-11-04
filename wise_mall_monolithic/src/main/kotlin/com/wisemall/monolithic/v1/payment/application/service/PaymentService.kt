package com.wisemall.monolithic.v1.payment.application.service

import com.wisemall.monolithic.v1.payment.application.enums.PaymentType
import com.wisemall.monolithic.v1.payment.application.usecase.OrderFinder
import com.wisemall.monolithic.v1.payment.application.usecase.PaymentFinder
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service


private val log = KotlinLogging.logger {}

@Service
class PaymentService(
    private val paymentFinder: PaymentFinder,
    private val orderFinder: OrderFinder
) {
    fun createPayment(
        orderId: Long,
        paymentType: PaymentType,
        amount: Double,
    ) {

        //orderId로 Order 조회하여 validation
    }

}