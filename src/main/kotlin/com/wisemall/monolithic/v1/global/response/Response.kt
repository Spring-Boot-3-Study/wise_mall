package com.wisemall.monolithic.v1.global.response

import java.util.*

/**
 * Adapter 응답 공통 코드
 */
interface Response {

    fun getCode(): Int

    fun getMessage(): String

    /**
     * 응답 객체 생성
     */
    fun toResponseDto() : ResponseDto<Map<String, Any>> {
        return ResponseDto(
            code = this.getCode(),
            message = this.getMessage(),
            result = Collections.emptyMap(),
        )
    }

    /**
     * 응답 객체 생성
     */
    fun <T> toResponseDto(result: T) : ResponseDto<T> {
        return ResponseDto(
            code = this.getCode(),
            message = this.getMessage(),
            result = result,
        )
    }
}