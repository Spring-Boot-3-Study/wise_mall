package com.wise.mall.product.application.port.out

import com.wise.mall.product.application.domain.model.Product

interface ProductPersistPort {

    fun createProduct(product: Product)

    fun updateProduct(product: Product)
}