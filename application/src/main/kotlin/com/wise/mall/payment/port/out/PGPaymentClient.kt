package com.wise.mall.payment.port.out

interface PGPaymentClient {
    fun approvePayment(code : String): String
}