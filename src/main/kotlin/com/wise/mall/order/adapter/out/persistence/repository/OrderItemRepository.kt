package com.wise.mall.order.adapter.out.persistence.repository

import com.wise.mall.order.adapter.out.persistence.entity.OrderEntity
import com.wise.mall.order.adapter.out.persistence.entity.OrderItemEntity
import com.wise.mall.order.domain.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface OrderItemRepository: JpaRepository<OrderItemEntity, Long> {
    fun findByOrderId(orderid: Long): List<OrderItemEntity>
}