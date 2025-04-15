package com.wise.mall.product.application.service

import com.wise.mall.product.application.domain.model.Product
import com.wise.mall.product.application.exception.InvalidPriceException
import com.wise.mall.product.application.exception.InvalidStateException
import com.wise.mall.product.application.port.`in`.ApprovalProductUseCase
import com.wise.mall.product.application.port.`in`.ProductUseCase
import com.wise.mall.product.application.port.`in`.command.*
import com.wise.mall.product.application.port.out.ProductPersistPort
import com.wise.mall.product.application.port.out.ProductReadPort
import com.wise.mall.product.application.vo.CreateProductVo
import com.wise.mall.product.application.vo.UpdateProductVo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService (
    private val productReadPort: ProductReadPort,
    private val productPersistPort: ProductPersistPort,
) : ApprovalProductUseCase, ProductUseCase {

    @Transactional
    override fun createProduct(command: CreateProductCommand) {

        // 금액 음수 여부 판별
        if (command.price < 0) {
            throw InvalidPriceException(price = command.price)
        }

        productPersistPort.createProduct(
            createProductVo = CreateProductVo(
                name = command.name,
                price = command.price,
                state = 0,
            )
        )
    }

    @Transactional(readOnly = true)
    override fun getProduct(command: GetProductCommand): Product {
        return productReadPort.getProduct(id = command.id)
    }

    @Transactional(readOnly = true)
    override fun getProducts(command: GetProductsCommand): List<Product> {
        return productReadPort.getProducts(
            page = command.page,
            size = command.size,
        )
    }

    @Transactional
    override fun approvalRequestProduct(command: ApprovalRequestProductCommand) {

        val product = productReadPort.getProduct(id = command.id)

        // 거절 상태가 아닌 경우
        if (product.state != -1) {
            throw InvalidStateException(id = product.id)
        }

        productPersistPort.updateProduct(
            updateProductVo = UpdateProductVo.of(product)
        )
    }

    @Transactional
    override fun approvalAllowProduct(command: ApprovalAllowProductCommand) {

        val product = productReadPort.getProduct(id = command.id)

        product.approvalAllow()

        productPersistPort.updateProduct(
            updateProductVo = UpdateProductVo.of(product)
        )
    }

    @Transactional
    override fun approvalDenyProduct(command: ApprovalDenyProductCommand) {

        val product = productReadPort.getProduct(id = command.id)

        product.approvalDeny()

        productPersistPort.updateProduct(
            updateProductVo = UpdateProductVo.of(product)
        )
    }
}