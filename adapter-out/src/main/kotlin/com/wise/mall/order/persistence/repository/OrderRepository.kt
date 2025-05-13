package com.wise.mall.order.persistence.repository

import com.wise.mall.order.persistence.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<OrderEntity, Long> {
}