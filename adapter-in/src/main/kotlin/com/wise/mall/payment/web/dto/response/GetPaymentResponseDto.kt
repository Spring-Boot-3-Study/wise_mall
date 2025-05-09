package com.wise.mall.payment.web.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class GetPaymentResponseDto(
    val paymentId : Long? = null,
    val paymentCode: String,
    val status: String,
    val method : String,
    val orderId : Long,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss", timezone = "Asia/Seoul")
    val createdAt: LocalDateTime ?= null,
)
