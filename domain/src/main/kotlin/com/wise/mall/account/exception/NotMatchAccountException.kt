package com.wise.mall.account.exception

import com.wise.mall.common.exception.ErrorException


class NotMatchAccountException (
): ErrorException(
    errorCode = AccountApplicationErrorCode.ACCOUNT_NOT_MATCH_ACCOUNT,
    result = mapOf(),
)