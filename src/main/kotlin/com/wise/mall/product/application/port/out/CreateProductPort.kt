package com.wise.mall.product.application.port.out

import com.wise.mall.product.application.port.out.vo.ProductVo

interface CreateProductPort {
    operator fun invoke(productVo: ProductVo)
}