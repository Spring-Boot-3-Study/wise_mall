package com.wise.mall.account.exception

import com.wise.mall.global.exception.ErrorException

class AlreadyExistsEmailException (
    private val email: String,
): ErrorException(
    errorCode = AccountApplicationErrorCode.ACCOUNT_ALREADY_EXISTS_EMAIL,
    result = mapOf("email" to email),
)