package com.wise.mall.product.adapter.out.persistence

import com.wise.mall.product.adapter.out.persistence.exception.NotExistsProductEntityException
import com.wise.mall.product.adapter.out.persistence.repository.ProductRepository
import com.wise.mall.product.application.port.out.ProductReadPort
import com.wise.mall.product.application.port.out.vo.ProductVo
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ProductReadAdapter (
    private val productRepository: ProductRepository
) : ProductReadPort {

    @Transactional(readOnly = true)
    override fun getProduct(id: Long): ProductVo = productRepository.findByIdOrNull(id)?.let { productEntity ->
        ProductVo(
            id = productEntity.id!!,
            name = productEntity.name,
            price = productEntity.price,
            state = productEntity.state,
            createdAt = productEntity.createdAt!!,
            updatedAt = productEntity.updatedAt!!,

        )
    } ?: throw NotExistsProductEntityException(id = id)

    @Transactional(readOnly = true)
    override fun getProducts(page: Int, size: Int): List<ProductVo> {

        val pageable = PageRequest.of(page - 1, size)

        return productRepository.findAll(pageable).content.map { productEntity ->
            ProductVo(
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