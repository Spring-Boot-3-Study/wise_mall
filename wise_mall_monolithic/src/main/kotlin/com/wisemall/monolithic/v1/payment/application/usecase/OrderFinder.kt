package com.wisemall.monolithic.v1.payment.application.usecase

import com.wisemall.monolithic.v1.order.persistence.repository.OrderJpaRepository
import org.springframework.stereotype.Component

@Component
class OrderFinder (
    private val orderRepository: OrderJpaRepository,
) {
    fun getOrder(orderId: Long, userId: Long) {

    }
}