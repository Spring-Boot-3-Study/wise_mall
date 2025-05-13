package com.wise.mall.product.persistence.repository

import com.wise.mall.product.persistence.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, Long> {
}