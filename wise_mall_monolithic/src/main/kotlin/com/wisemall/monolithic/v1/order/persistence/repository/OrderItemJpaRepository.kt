package com.wisemall.monolithic.v1.order.persistence.repository

import com.wisemall.monolithic.v1.order.adapter.out.persistence.entity.OrderItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemJpaRepository: JpaRepository<OrderItemEntity, Long> {
    fun findByOrderId(orderid: Long): List<OrderItemEntity>
}