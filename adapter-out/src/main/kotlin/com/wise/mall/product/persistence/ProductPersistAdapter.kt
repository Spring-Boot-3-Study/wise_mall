package com.wise.mall.product.persistence

import com.wise.mall.product.persistence.entity.ProductEntity
import com.wise.mall.product.persistence.exception.NotExistsProductEntityException
import com.wise.mall.product.persistence.repository.ProductRepository
import com.wise.mall.product.port.out.ProductPersistPort
import com.wise.mall.product.vo.CreateProductVo
import com.wise.mall.product.vo.UpdateProductVo
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