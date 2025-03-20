package com.wise.mall.global.response

data class ResponseDto<T> (
    val code: Int,
    val message: String,
    val result: T
)