package com.wise.mall.global.exception

open class ApplicationException(
    val applicationError: ApplicationError,
) : RuntimeException()