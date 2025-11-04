package com.wise.mall.v1.global.exception

/**
 * Application 공통 예외 코드
 */
interface ErrorCode {

    fun getCode(): Int

    fun getMessage(): String
}