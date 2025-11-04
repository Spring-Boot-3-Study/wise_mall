package com.wisemall.monolithic.v1.order.persistence.repository

import com.wisemall.monolithic.v1.order.persistence.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderJpaRepository: JpaRepository<OrderEntity, Long> {
}