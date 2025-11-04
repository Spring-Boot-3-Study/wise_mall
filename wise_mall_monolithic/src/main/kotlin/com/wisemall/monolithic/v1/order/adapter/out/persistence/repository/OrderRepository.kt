package com.wise.mall.v1.order.adapter.out.persistence.repository

import com.wise.mall.v1.order.adapter.out.persistence.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<OrderEntity, Long> {
}