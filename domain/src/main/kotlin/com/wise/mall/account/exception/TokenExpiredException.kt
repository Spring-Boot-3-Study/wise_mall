package com.wise.mall.account.exception

import com.wise.mall.common.exception.ErrorException


class TokenExpiredException (
    private val token: String,
): ErrorException(
    errorCode = AccountApplicationErrorCode.ACCOUNT_TOKEN_EXPIRED,
    result = mapOf("token" to token),
)