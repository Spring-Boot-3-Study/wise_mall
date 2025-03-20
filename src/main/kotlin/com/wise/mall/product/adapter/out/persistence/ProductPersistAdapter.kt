package com.wise.mall.product.adapter.out.persistence

import com.wise.mall.product.adapter.out.persistence.entity.ProductEntity
import com.wise.mall.product.adapter.out.persistence.exception.NotExistsProductEntityException
import com.wise.mall.product.adapter.out.persistence.repository.ProductRepository
import com.wise.mall.product.application.port.out.ProductPersistPort
import com.wise.mall.product.application.port.out.vo.CreateProductVo
import com.wise.mall.product.application.port.out.vo.ProductVo
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
                state = 0,
            )
        )
    }

    @Transactional
    override fun updateProduct(productVo: ProductVo) {

        val productEntity = productRepository.findByIdOrNull(productVo.id)
            ?: throw NotExistsProductEntityException(id = productVo.id)

        productEntity.updateState(productVo.state)

        productRepository.save(productEntity)
    }
}