package com.wise.mall.global.exception

interface ApplicationError {

    fun getCode(): Int

    fun getMessage(): String
}