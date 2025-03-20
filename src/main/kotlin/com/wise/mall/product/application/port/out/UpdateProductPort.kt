package com.wise.mall.product.application.port.out

import com.wise.mall.product.application.port.out.vo.ProductVo

interface UpdateProductPort {
    operator fun invoke(id: Long, productVo: ProductVo)
}