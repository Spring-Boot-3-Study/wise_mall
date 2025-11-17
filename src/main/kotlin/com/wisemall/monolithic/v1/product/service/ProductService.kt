package com.wisemall.monolithic.v1.product.service

import com.wisemall.monolithic.v1.product.service.vo.Product

interface ProductService {

    fun createProduct(name: String, price: Int)

    fun getProduct(id: Long): Product

    fun getProducts(page: Int, size: Int): List<Product>

    fun approvalRequestProduct(id: Long)

    fun approvalAllowProduct(id: Long)

    fun approvalDenyProduct(id: Long)
}