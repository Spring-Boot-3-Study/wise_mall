package com.wisemall.monolithic.v1.product.adapter.out.persistence

import com.wisemall.monolithic.v1.product.adapter.out.persistence.entity.ProductEntity
import com.wisemall.monolithic.v1.product.adapter.out.persistence.exception.NotExistsProductEntityException
import com.wisemall.monolithic.v1.product.adapter.out.persistence.repository.ProductRepository
import com.wisemall.monolithic.v1.product.application.port.out.ProductPersistPort
import com.wisemall.monolithic.v1.product.application.vo.CreateProductVo
import com.wisemall.monolithic.v1.product.application.vo.UpdateProductVo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ProductPersistAdapter (
    private val productRepository: ProductRepository
) : ProductPersistPort {

    @Transactional
    override fun createProduct(createProductVo: CreateProductVo) {
        productRepository.save(
            ProductEntity(
                name = createProductVo.name,
                price = createProductVo.price,
                state = createProductVo.state,
            )
        )
    }

    @Transactional
    override fun updateProduct(updateProductVo: UpdateProductVo) {

        val productEntity = productRepository.findByIdOrNull(updateProductVo.id)
            ?: throw NotExistsProductEntityException(id = updateProductVo.id)

        productEntity.updateState(updateProductVo.state)

        productRepository.save(productEntity)
    }
}