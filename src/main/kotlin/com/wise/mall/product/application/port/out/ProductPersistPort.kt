package com.wise.mall.product.application.port.out

import com.wise.mall.product.application.port.out.vo.CreateProductVo
import com.wise.mall.product.application.port.out.vo.ProductVo

interface ProductPersistPort {

    fun createProduct(createProductVo: CreateProductVo)

    fun updateProduct(productVo: ProductVo)
}