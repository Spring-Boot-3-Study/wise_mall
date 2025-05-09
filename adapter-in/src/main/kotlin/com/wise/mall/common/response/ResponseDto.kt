package com.wise.mall.common.response

/**
 * Adapter 공통 응답 Dto 클래스
 */
data class ResponseDto<T> (
    val code: Int,
    val message: String,
    val result: T
)