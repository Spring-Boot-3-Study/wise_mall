package com.wise.mall.order.adapter.out.persistence.repository

import com.wise.mall.order.adapter.out.persistence.entity.OrderItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<OrderItemEntity, Long> {
}