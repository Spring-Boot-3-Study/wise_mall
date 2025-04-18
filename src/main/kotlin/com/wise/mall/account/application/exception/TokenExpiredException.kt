package com.wise.mall.account.application.exception

import com.wise.mall.global.exception.ErrorException

class TokenExpiredException (
    private val token: String,
): ErrorException(
    errorCode = AccountApplicationErrorCode.ACCOUNT_TOKEN_EXPIRED,
    result = mapOf("token" to token),
)