package com.wisemall.monolithic.v1.global.response

import com.fasterxml.jackson.annotation.JsonIgnore
import com.wisemall.monolithic.v1.global.error.BusinessException
import com.wisemall.monolithic.v1.global.error.ExceptionDto
import org.springframework.http.HttpStatus

class ApiResponse<T>(
    @JsonIgnore
    val httpStatus: HttpStatus,

    val success: Boolean,

    val data: T? = null,

    val error:ExceptionDto? = null

) {
    companion object {
        fun <T> ok(data: T): ApiResponse<T> = ApiResponse(
            HttpStatus.OK, true, data, null
        )
        fun <T> created(data: T): ApiResponse<T> = ApiResponse(
            HttpStatus.CREATED, true, data, null
        )
        fun <T> error(e: BusinessException): ApiResponse<T> = ApiResponse(
            e.errorCode.httpStatus, false, null, ExceptionDto(e.errorCode)
        )
    }
}