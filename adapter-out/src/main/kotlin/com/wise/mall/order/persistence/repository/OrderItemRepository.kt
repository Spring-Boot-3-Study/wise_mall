package com.wise.mall.order.persistence.repository

import com.wise.mall.order.persistence.entity.OrderItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<OrderItemEntity, Long> {
    fun findByOrderId(orderid: Long): List<OrderItemEntity>
}