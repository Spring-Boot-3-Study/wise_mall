package com.wise.mall.global.exception

import java.util.*

/**
 * Adapter 공통 예외 클래스
 */
open class ErrorException(
    open val errorCode: ErrorCode,
    open val result: Map<String, Any> = Collections.emptyMap(),
) : RuntimeException()