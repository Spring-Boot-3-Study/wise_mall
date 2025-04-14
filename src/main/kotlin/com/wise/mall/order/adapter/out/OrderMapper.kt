package com.wise.mall.order.adapter.out

import com.wise.mall.order.adapter.out.persistence.entity.OrderEntity
import com.wise.mall.order.domain.model.Order
import com.wise.mall.order.domain.model.OrderStatus
import com.wise.mall.order.domain.vo.OrderToCreate
import org.springframework.stereotype.Component

@Component
class OrderMapper {

    fun toDomain(orderEntity: OrderEntity): Order {
        return Order(
            orderId = orderEntity.id!!,
            address = orderEntity.address,
            status = orderEntity.status,
            accountId = orderEntity.accountId,
            totalPrice = orderEntity.totalPrice,
            createdAt = orderEntity.createdAt!!,
            updatedAt = orderEntity.updatedAt!!,
        )
    }

    fun toNewEntity(orderToCreate: OrderToCreate): OrderEntity {
        return OrderEntity (
            totalPrice = 0,
            status = OrderStatus.PENDING,
            accountId = orderToCreate.accountId,
            address = orderToCreate.address,
        )
    }
}