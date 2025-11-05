package com.wisemall.monolithic.v1.payment.application.application

import com.wisemall.monolithic.v1.payment.api.dto.WebHookResponse
import com.wisemall.monolithic.v1.payment.application.domain.Payment
import com.wisemall.monolithic.v1.payment.application.exception.PgFailException
import org.springframework.stereotype.Component
import java.util.*

@Component
class PaymentGatewayDummy(
): PaymentGateway {

    //전송 후 transaction Id 반환
    override fun transfer(payment: Payment): WebHookResponse {
        // 외부 API 호출 시뮬레이션
        Thread.sleep(1500)

        val response = WebHookResponse(
            transactionId = UUID.randomUUID().toString(),
            status = "SUCCESS",
            message = "Payment successful"
        )
        require(response.status == "SUCCESS") { throw PgFailException() }

        return response
    }

}