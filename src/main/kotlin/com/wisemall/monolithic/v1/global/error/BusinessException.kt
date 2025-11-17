package com.wisemall.monolithic.v1.global.error

class BusinessException(
    val errorCode: ErrorCodeEnum,
): RuntimeException(errorCode.message) {

}