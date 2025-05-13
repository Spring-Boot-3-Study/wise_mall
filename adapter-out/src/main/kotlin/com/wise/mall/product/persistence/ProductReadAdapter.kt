package com.wise.mall.product.persistence

import com.wise.mall.product.model.Product
import com.wise.mall.product.persistence.exception.NotExistsProductEntityException
import com.wise.mall.product.persistence.repository.ProductRepository
import com.wise.mall.product.port.out.ProductReadPort
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ProductReadAdapter (
    private val productRepository: ProductRepository
) : ProductReadPort {

    @Transactional(readOnly = true)
    override fun getProduct(id: Long): Product = productRepository.findByIdOrNull(id)?.let { productEntity ->
        Product(
            id = productEntity.id!!,
            name = productEntity.name,
            price = productEntity.price,
            state = productEntity.state,
            createdAt = productEntity.createdAt!!,
            updatedAt = productEntity.updatedAt!!,

        )
    } ?: throw NotExistsProductEntityException(id = id)

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
}