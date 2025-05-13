package com.wise.mall.product.port.out

import com.wise.mall.product.model.Product

interface ProductReadPort {

    fun getProduct(id: Long): Product

    fun getProducts(page: Int, size: Int): List<Product>
}