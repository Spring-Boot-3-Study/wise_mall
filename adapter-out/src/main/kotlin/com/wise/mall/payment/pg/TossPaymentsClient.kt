package com.wise.mall.payment.pg

import com.wise.mall.payment.port.out.PGPaymentClient
import org.springframework.stereotype.Component


@Component
class TossPaymentsClient (
) : PGPaymentClient {
    override fun approvePayment(code: String): String {
        // PG사로부터 상태 코드를 받아옴.
        return "SUCCESS";
    }
}