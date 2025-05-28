package com.wise.mall.order.mapper

import com.wise.mall.order.model.OrderItem
import com.wise.mall.order.persistence.entity.OrderItemEntity
import com.wise.mall.product.model.Product
import org.springframework.stereotype.Component

@Component
class OrderItemMapper {
    fun toDomain(orderItem: OrderItemEntity): OrderItem {
        return OrderItem(
            productId = orderItem.productId,
            quantity = orderItem.quantity,
            price = orderItem.price,
        )
    }
}