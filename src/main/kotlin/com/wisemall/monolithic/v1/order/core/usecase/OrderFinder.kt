package com.wisemall.monolithic.v1.order.core.usecase

import com.wisemall.monolithic.v1.order.persistence.mapper.OrderItemMapper
import com.wisemall.monolithic.v1.order.persistence.mapper.OrderMapper
import com.wisemall.monolithic.v1.order.core.domain.Order
import com.wisemall.monolithic.v1.order.core.domain.OrderItem
import com.wisemall.monolithic.v1.order.domain.exception.OrderNotFoundException
import com.wisemall.monolithic.v1.order.persistence.repository.OrderItemJpaRepository
import com.wisemall.monolithic.v1.order.persistence.repository.OrderJpaRepository
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrElse

@Component
class OrderFinder (
    private val orderRepository: OrderJpaRepository,
    private val orderItemRepository: OrderItemJpaRepository,
    private val orderMapper: OrderMapper,
    private val orderItemMapper: OrderItemMapper
) {

    fun getOrderById(orderId: Long): Order {
        val order = orderRepository.findById(orderId).getOrElse { throw OrderNotFoundException(orderId) }
        return orderMapper.toDomain(order)
    }

    fun getOrderItemsByOrderId(orderId: Long): List<OrderItem> {
        return orderItemRepository.findByOrderId(orderId).map { orderItemMapper.toDomain(it) }
    }

}