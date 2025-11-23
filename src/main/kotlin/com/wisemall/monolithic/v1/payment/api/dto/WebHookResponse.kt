package com.wisemall.monolithic.v1.payment.api.dto

data class WebHookResponse(
    val transactionId: String,
    val status: String,
    val message: String,
)