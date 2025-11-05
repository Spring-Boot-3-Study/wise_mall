package com.wisemall.monolithic.v1.product.application.port.out

import com.wisemall.monolithic.v1.product.application.vo.CreateProductVo
import com.wisemall.monolithic.v1.product.application.vo.UpdateProductVo

interface ProductPersistPort {

    fun createProduct(createProductVo: CreateProductVo)

    fun updateProduct(updateProductVo: UpdateProductVo)
}