package com.wise.mall.v1.product.application.port.`in`

import com.wise.mall.v1.product.application.domain.model.Product
import com.wise.mall.v1.product.application.port.`in`.command.CreateProductCommand
import com.wise.mall.v1.product.application.port.`in`.command.GetProductCommand
import com.wise.mall.v1.product.application.port.`in`.command.GetProductsCommand

interface ProductUseCase {

    fun createProduct(command: CreateProductCommand)

    fun getProduct(command: GetProductCommand): Product

    fun getProducts(command: GetProductsCommand): List<Product>
}