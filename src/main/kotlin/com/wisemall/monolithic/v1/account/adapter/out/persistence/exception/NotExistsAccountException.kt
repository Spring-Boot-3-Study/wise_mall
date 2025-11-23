package com.wisemall.monolithic.v1.account.adapter.out.persistence.exception

import com.wisemall.monolithic.v1.global.exception.ErrorException

class NotExistsAccountException (
): ErrorException(
    errorCode = AccountAdapterErrorCode.ACCOUNT_NOT_EXISTS_ACCOUNT,
    result = mapOf(),
)