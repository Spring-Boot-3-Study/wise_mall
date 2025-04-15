package com.wise.mall.order.adapter.out.persistence.repository

import com.wise.mall.order.adapter.out.persistence.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<OrderEntity, Long> {
}