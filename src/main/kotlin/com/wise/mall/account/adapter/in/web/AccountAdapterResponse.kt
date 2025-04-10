package com.wise.mall.account.adapter.`in`.web

import com.wise.mall.global.response.Response

enum class AccountAdapterResponse(
    private val code: Int,
    private val message: String
) : Response {

    ACCOUNT_JOIN_SUCCESS(100, "회원 가입에 성공했습니다."),
    ACCOUNT_LOGIN_SUCCESS(101, "로그인에 성공했습니다."),
    ACCOUNT_LOGOUT_SUCCESS(102, "로그아웃에 성공했습니다."),
    ACCOUNT_REISSUE_SUCCESS(103, "토큰 재발행에 성공했습니다."),
    ;

    override fun getCode(): Int = this.code
    override fun getMessage(): String = this.message
}