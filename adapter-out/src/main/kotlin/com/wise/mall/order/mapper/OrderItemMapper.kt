package com.wise.mall.order.mapper

import com.wise.mall.order.model.OrderItem
import com.wise.mall.order.persistence.entity.OrderItemEntity
import com.wise.mall.product.model.Product
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