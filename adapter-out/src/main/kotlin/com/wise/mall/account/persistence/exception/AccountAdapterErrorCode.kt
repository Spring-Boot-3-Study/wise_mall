package com.wise.mall.account.persistence.exception

import com.wise.mall.common.exception.ErrorCode

enum class AccountAdapterErrorCode(
    private val code: Int,
    private val message: String,
) : ErrorCode {

    ACCOUNT_NOT_EXISTS_ACCOUNT(100, "회원 정보가 존재하지 않습니다."),
    ;

    override fun getCode(): Int = this.code
    override fun getMessage(): String = this.message
}