package com.wise.mall.global.exception

import com.wise.mall.global.response.Response
import java.util.*

open class AdapterException(
    val response: Response,
    val result: Map<String, Any> = Collections.emptyMap(),
) : RuntimeException()