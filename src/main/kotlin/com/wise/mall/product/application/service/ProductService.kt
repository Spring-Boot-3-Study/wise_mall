package com.wise.mall.product.application.service

import com.wise.mall.product.application.port.`in`.ApprovalProductUseCase
import com.wise.mall.product.application.port.`in`.ProductUseCase
import com.wise.mall.product.application.port.`in`.command.*
import org.springframework.stereotype.Service

@Service
class ProductService (

) : ApprovalProductUseCase, ProductUseCase {

    override fun approvalAllowProduct(command: ApprovalAllowProductCommand) {
        TODO("Not yet implemented")
    }

    override fun approvalDenyProduct(command: ApprovalDenyProductCommand) {
        TODO("Not yet implemented")
    }

    override fun approvalRequestProduct(command: ApprovalRequestProductCommand) {
        TODO("Not yet implemented")
    }

    override fun createProduct(command: CreateProductCommand) {
        TODO("Not yet implemented")
    }

    override fun getProduct(command: GetProductCommand) {
        TODO("Not yet implemented")
    }

    override fun getProducts(command: GetProductsCommand) {
        TODO("Not yet implemented")
    }
}