package com.wise.mall.product.application.port.out

import com.wise.mall.product.application.domain.model.Product

interface ProductReadPort {

    fun getProduct(id: Long): Product

    fun getProducts(page: Int, size: Int): List<Product>
}