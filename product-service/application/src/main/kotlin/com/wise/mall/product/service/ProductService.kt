package com.wise.mall.product.service

import com.wise.mall.product.dto.ProductDto
import com.wise.mall.product.exception.InvalidPriceException
import com.wise.mall.product.exception.InvalidStateException
import com.wise.mall.product.model.Product
import com.wise.mall.product.port.`in`.ApprovalProductUseCase
import com.wise.mall.product.port.`in`.ProductUseCase
import com.wise.mall.product.port.`in`.command.*
import com.wise.mall.product.port.out.ProductPersistPort
import com.wise.mall.product.port.out.ProductReadPort
import com.wise.mall.product.vo.CreateProductVo
import com.wise.mall.product.vo.UpdateProductVo
import org.springframework.stereotype.Service

@Service
class ProductService (
    private val productReadPort: ProductReadPort,
    private val productPersistPort: ProductPersistPort,
) : ApprovalProductUseCase, ProductUseCase {

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

    override fun getProduct(command: GetProductCommand): ProductDto {
        return productReadPort.getProduct(id = command.id).let { product: Product ->
            ProductDto(
                id = product.id,
                name = product.name,
                price = product.price,
                state = product.state,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt,
            )
        }
    }

    override fun getProducts(command: GetProductsCommand): List<ProductDto> {
        return productReadPort.getProducts(
            page = command.page,
            size = command.size,
        ).map { product: Product ->
            ProductDto(
                id = product.id,
                name = product.name,
                price = product.price,
                state = product.state,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt,
            )
        }
    }

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

    override fun approvalAllowProduct(command: ApprovalAllowProductCommand) {

        val product = productReadPort.getProduct(id = command.id)

        product.approvalAllow()

        productPersistPort.updateProduct(
            updateProductVo = UpdateProductVo.of(product)
        )
    }

    override fun approvalDenyProduct(command: ApprovalDenyProductCommand) {

        val product = productReadPort.getProduct(id = command.id)

        product.approvalDeny()

        productPersistPort.updateProduct(
            updateProductVo = UpdateProductVo.of(product)
        )
    }
}