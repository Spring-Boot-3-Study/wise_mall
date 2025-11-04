package com.wisemall.monolithic.v1.account.application.exception

import com.wisemall.monolithic.v1.global.exception.ErrorException

class NotMatchAccountException (
): ErrorException(
    errorCode = AccountApplicationErrorCode.ACCOUNT_NOT_MATCH_ACCOUNT,
    result = mapOf(),
)