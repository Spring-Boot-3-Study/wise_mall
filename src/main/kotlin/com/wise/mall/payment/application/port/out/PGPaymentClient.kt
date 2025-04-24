package com.wise.mall.payment.application.port.out

interface PGPaymentClient {
    fun approvePayment(code : String): String
}