package com.wisemall.monolithic.v1.product.adapter.out.persistence.repository

import com.wisemall.monolithic.v1.product.adapter.out.persistence.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, Long> {
}