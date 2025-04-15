package com.wise.mall.account.application.exception

import com.wise.mall.global.exception.ErrorException

class NotMatchAccountException (
): ErrorException(
    errorCode = AccountApplicationErrorCode.ACCOUNT_NOT_MATCH_ACCOUNT,
    result = mapOf(),
)