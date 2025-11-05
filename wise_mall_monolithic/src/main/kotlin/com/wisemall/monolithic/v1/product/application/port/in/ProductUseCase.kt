package com.wisemall.monolithic.v1.product.application.port.`in`

import com.wisemall.monolithic.v1.product.application.domain.model.Product
import com.wisemall.monolithic.v1.product.application.port.`in`.command.CreateProductCommand
import com.wisemall.monolithic.v1.product.application.port.`in`.command.GetProductCommand
import com.wisemall.monolithic.v1.product.application.port.`in`.command.GetProductsCommand

interface ProductUseCase {

    fun createProduct(command: CreateProductCommand)

    fun getProduct(command: GetProductCommand): Product

    fun getProducts(command: GetProductsCommand): List<Product>
}