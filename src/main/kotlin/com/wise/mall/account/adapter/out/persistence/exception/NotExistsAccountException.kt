package com.wise.mall.account.adapter.out.persistence.exception

import com.wise.mall.global.exception.ErrorException

class NotExistsAccountException (
): ErrorException(
    errorCode = AccountAdapterErrorCode.ACCOUNT_NOT_EXISTS_ACCOUNT,
    result = mapOf(),
)