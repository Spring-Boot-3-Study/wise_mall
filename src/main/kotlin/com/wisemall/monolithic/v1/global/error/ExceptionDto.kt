package com.wisemall.monolithic.v1.global.error

class ExceptionDto(
    errorCode: ErrorCodeEnum,
)  {
    val message: String = errorCode.message
    val code: Int = errorCode.code
}
