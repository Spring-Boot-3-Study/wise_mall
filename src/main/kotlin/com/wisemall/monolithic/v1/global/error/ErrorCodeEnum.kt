package com.wisemall.monolithic.v1.global.error

import org.springframework.http.HttpStatus

enum class ErrorCodeEnum(
    val code: Int,
    val httpStatus: HttpStatus,
    val message: String,
) {




}