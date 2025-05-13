package com.wise.mall.product.port.`in`

import com.wise.mall.product.dto.ProductDto
import com.wise.mall.product.port.`in`.command.CreateProductCommand
import com.wise.mall.product.port.`in`.command.GetProductCommand
import com.wise.mall.product.port.`in`.command.GetProductsCommand

interface ProductUseCase {

    fun createProduct(command: CreateProductCommand)

    fun getProduct(command: GetProductCommand): ProductDto

    fun getProducts(command: GetProductsCommand): List<ProductDto>
}