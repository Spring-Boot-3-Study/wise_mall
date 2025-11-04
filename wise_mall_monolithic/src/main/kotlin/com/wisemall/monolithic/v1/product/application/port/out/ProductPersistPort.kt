package com.wise.mall.v1.product.application.port.out

import com.wise.mall.v1.product.application.vo.CreateProductVo
import com.wise.mall.v1.product.application.vo.UpdateProductVo

interface ProductPersistPort {

    fun createProduct(createProductVo: CreateProductVo)

    fun updateProduct(updateProductVo: UpdateProductVo)
}