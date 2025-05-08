package com.wise.mall.product.port.out

import com.wise.mall.product.application.vo.CreateProductVo
import com.wise.mall.product.application.vo.UpdateProductVo

interface ProductPersistPort {

    fun createProduct(createProductVo: CreateProductVo)

    fun updateProduct(updateProductVo: UpdateProductVo)
}