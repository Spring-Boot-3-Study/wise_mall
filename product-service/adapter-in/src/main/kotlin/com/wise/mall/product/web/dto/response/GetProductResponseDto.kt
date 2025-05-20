package com.wise.mall.product.web.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class GetProductResponseDto(

    val id: Long,

    val name: String,

    val price: Int,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss", timezone = "Asia/Seoul")
    val createdAt: LocalDateTime,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss", timezone = "Asia/Seoul")
    val updatedAt: LocalDateTime,

    val isApprove: Boolean,
)
