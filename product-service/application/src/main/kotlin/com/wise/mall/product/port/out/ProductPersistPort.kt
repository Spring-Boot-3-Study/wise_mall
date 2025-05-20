package com.wise.mall.product.port.out

import com.wise.mall.product.vo.CreateProductVo
import com.wise.mall.product.vo.UpdateProductVo


interface ProductPersistPort {

    fun createProduct(createProductVo: CreateProductVo)

    fun updateProduct(updateProductVo: UpdateProductVo)
}