package com.wise.mall.v1.account.adapter.out.persistence.exception

import com.wise.mall.v1.global.exception.ErrorException

class NotExistsAccountException (
): ErrorException(
    errorCode = AccountAdapterErrorCode.ACCOUNT_NOT_EXISTS_ACCOUNT,
    result = mapOf(),
)