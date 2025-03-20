package com.wise.mall.product.application.port.out

interface GetProductPort {
    operator fun invoke(id: Long)
}