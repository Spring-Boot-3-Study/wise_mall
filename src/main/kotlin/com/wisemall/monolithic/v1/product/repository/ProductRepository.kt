package com.wisemall.monolithic.v1.product.repository

import com.wisemall.monolithic.v1.product.repository.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, Long> {
}