package com.wise.mall.v1.order.adapter.out.persistence.repository

import com.wise.mall.v1.order.adapter.out.persistence.entity.OrderItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<OrderItemEntity, Long> {
    fun findByOrderId(orderid: Long): List<OrderItemEntity>
}