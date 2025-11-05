package com.wisemall.monolithic.v1.order.persistence.mapper

import com.wisemall.monolithic.v1.order.persistence.entity.OrderItemEntity
import com.wisemall.monolithic.v1.order.core.domain.OrderItem
import com.wisemall.monolithic.v1.product.application.domain.model.Product
import org.springframework.stereotype.Component

@Component
class OrderItemMapper {
    fun toDomain(orderItem: OrderItemEntity): OrderItem {
        return OrderItem(
            product = Product(
                id = orderItem.product.id!!,
                name = orderItem.product.name,
                price = orderItem.product.price,
                state = orderItem.product.state,
                createdAt = orderItem.createdAt!!,
                updatedAt = orderItem.updatedAt!!
            ),
            quantity = orderItem.quantity,
            price = orderItem.price,
        )
    }
}