package com.wise.mall.payment.pg

import com.wise.mall.payment.application.port.out.PGPaymentClient
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class TossPaymentsClient (
) : PGPaymentClient{
    override fun approvePayment(code: String): String {
        // PG사로부터 상태 코드를 받아옴.
        return "SUCCESS";
    }
}