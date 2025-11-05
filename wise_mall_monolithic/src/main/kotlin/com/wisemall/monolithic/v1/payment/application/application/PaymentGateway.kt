package com.wisemall.monolithic.v1.payment.application.application

import com.wisemall.monolithic.v1.payment.api.dto.WebHookResponse
import com.wisemall.monolithic.v1.payment.application.domain.Payment

interface PaymentGateway {
    fun transfer(payment: Payment): WebHookResponse
}