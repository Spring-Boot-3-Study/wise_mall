package com.wisemall.monolithic.v1.product.service.impl

import com.wisemall.monolithic.v1.product.exception.InvalidPriceException
import com.wisemall.monolithic.v1.product.exception.NotExistsProductException
import com.wisemall.monolithic.v1.product.repository.ProductRepository
import com.wisemall.monolithic.v1.product.repository.entity.ProductEntity
import com.wisemall.monolithic.v1.product.service.ProductService
import com.wisemall.monolithic.v1.product.service.vo.Product
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductServiceImpl (
    private val productRepository: ProductRepository,
) : ProductService {

    @Transactional
    override fun createProduct(name: String, price: Int) {

        // 금액 음수 여부 판별
        if (price < 0) {
            throw InvalidPriceException(price = price)
        }

        productRepository.save(
            ProductEntity(
                name = name,
                price = price,
                state = 0,
            )
        )
    }

    @Transactional(readOnly = true)
    override fun getProduct(id: Long): Product {
        return productRepository.findByIdOrNull(id)?.let { productEntity ->
            Product(
                id = productEntity.id!!,
                name = productEntity.name,
                price = productEntity.price,
                state = productEntity.state,
                createdAt = productEntity.createdAt!!,
                updatedAt = productEntity.updatedAt!!,

                )
        } ?: throw NotExistsProductException(id = id)
    }

    @Transactional(readOnly = true)
    override fun getProducts(page: Int, size: Int): List<Product> {

        val pageable = PageRequest.of(page - 1, size)

        return productRepository.findAll(pageable).content.map { productEntity ->
            Product(
                id = productEntity.id!!,
                name = productEntity.name,
                price = productEntity.price,
                state = productEntity.state,
                createdAt = productEntity.createdAt!!,
                updatedAt = productEntity.updatedAt!!,
            )
        }
    }

    @Transactional
    override fun approvalRequestProduct(id: Long) {

        val productEntity = productRepository.findByIdOrNull(id)
            ?: throw NotExistsProductException(id = id)

        // 거절 상태인 경우
        if (productEntity.state == -1) {
            productEntity.state = 0
        }

        productRepository.save(productEntity)
    }

    @Transactional
    override fun approvalAllowProduct(id: Long) {

        val productEntity = productRepository.findByIdOrNull(id)
            ?: throw NotExistsProductException(id = id)

        productEntity.state = 1

        productRepository.save(productEntity)
    }

    @Transactional
    override fun approvalDenyProduct(id: Long) {

        val productEntity = productRepository.findByIdOrNull(id)
            ?: throw NotExistsProductException(id = id)

        productEntity.state = -1

        productRepository.save(productEntity)
    }
}