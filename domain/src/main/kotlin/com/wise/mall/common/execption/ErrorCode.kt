package com.wise.mall.common.execption

/**
 * Application 공통 예외 코드
 */
interface ErrorCode {

    fun getCode(): Int

    fun getMessage(): String
}