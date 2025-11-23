package com.wisemall.monolithic.v1.order.storage.repository

import com.wisemall.monolithic.v1.order.storage.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<OrderEntity, Long> {
}