package com.wisemall.monolithic.v1.order.storage.repository

import com.wisemall.monolithic.v1.order.storage.entity.OrderItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<OrderItemEntity, Long> {
    fun findByOrderId(orderid: Long): List<OrderItemEntity>
}