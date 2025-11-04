package com.wise.mall.v1.account.application.exception

import com.wise.mall.v1.global.exception.ErrorCode

enum class AccountApplicationErrorCode(
    private val code: Int,
    private val message: String,
) : ErrorCode {

    ACCOUNT_NOT_MATCH_ACCOUNT(100, "회원 정보가 일치하지 않습니다."),
    ACCOUNT_ALREADY_EXISTS_EMAIL(101, "이미 가입된 이메일입니다."),
    ACCOUNT_TOKEN_EXPIRED(102, "만료된 토큰입니다."),
    ;

    override fun getCode(): Int = this.code
    override fun getMessage(): String = this.message
}