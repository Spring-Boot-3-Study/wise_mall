package com.wise.mall.payment.adapter.`in`.web.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class GetPaymentResponseDto(
    val paymentId : Long,
    val paymentCode: String,
    val status: Char,
    val method : String,
    val orderId : Long,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss", timezone = "Asia/Seoul")
    val createdAt: LocalDateTime,
)
