package com.wise.mall.product.application.port.`in`

import com.wise.mall.product.application.port.`in`.command.CreateProductCommand
import com.wise.mall.product.application.port.`in`.command.GetProductCommand
import com.wise.mall.product.application.port.`in`.command.GetProductsCommand

interface ProductUseCase {

    fun createProduct(command: CreateProductCommand)

    fun getProduct(command: GetProductCommand)

    fun getProducts(command: GetProductsCommand)
}