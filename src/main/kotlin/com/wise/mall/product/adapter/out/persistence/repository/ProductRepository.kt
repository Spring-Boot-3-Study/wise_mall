package com.wise.mall.product.adapter.out.persistence.repository

import com.wise.mall.product.adapter.out.persistence.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, Long> {
}