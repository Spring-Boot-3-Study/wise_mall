package com.wise.mall.product.adapter.out.persistence

import com.wise.mall.product.adapter.out.persistence.entity.ProductEntity
import com.wise.mall.product.adapter.out.persistence.exception.NotExistsProductEntityException
import com.wise.mall.product.adapter.out.persistence.repository.ProductRepository
import com.wise.mall.product.application.domain.model.Product
import com.wise.mall.product.application.port.out.ProductPersistPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ProductPersistAdapter (
    private val productRepository: ProductRepository
) : ProductPersistPort {

    @Transactional
    override fun createProduct(product: Product) {
        productRepository.save(
            ProductEntity(
                name = product.name,
                price = product.price,
                state = 0,
            )
        )
    }

    @Transactional
    override fun updateProduct(product: Product) {

        val productEntity = productRepository.findByIdOrNull(product.id)
            ?: throw NotExistsProductEntityException(id = product.id ?: -1)

        productEntity.updateState(product.state)

        productRepository.save(productEntity)
    }
}