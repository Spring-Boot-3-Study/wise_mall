package com.wisemall.monolithic.v1.account.application.exception

import com.wisemall.monolithic.v1.global.exception.ErrorException

class AlreadyExistsEmailException (
    private val email: String,
): ErrorException(
    errorCode = AccountApplicationErrorCode.ACCOUNT_ALREADY_EXISTS_EMAIL,
    result = mapOf("email" to email),
)