package com.wise.mall.v1.product.application.port.out

import com.wise.mall.v1.product.application.domain.model.Product

interface ProductReadPort {

    fun getProduct(id: Long): Product

    fun getProducts(page: Int, size: Int): List<Product>
}