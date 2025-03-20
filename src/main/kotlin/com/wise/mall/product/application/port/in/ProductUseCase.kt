package com.wise.mall.product.application.port.`in`

import com.wise.mall.product.application.port.`in`.command.CreateProductCommand
import com.wise.mall.product.application.port.`in`.command.GetProductCommand
import com.wise.mall.product.application.port.`in`.command.GetProductsCommand
import com.wise.mall.product.application.port.out.vo.ProductVo

interface ProductUseCase {

    fun createProduct(command: CreateProductCommand)

    fun getProduct(command: GetProductCommand): ProductVo

    fun getProducts(command: GetProductsCommand): List<ProductVo>
}