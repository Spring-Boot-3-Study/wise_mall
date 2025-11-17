package com.wisemall.monolithic.v1.order.storage.mapper

import com.wisemall.monolithic.v1.order.api.dto.OrderToCreate
import com.wisemall.monolithic.v1.order.core.domain.Order
import com.wisemall.monolithic.v1.global.enums.OrderStatus
import com.wisemall.monolithic.v1.order.storage.entity.OrderEntity
import org.springframework.stereotype.Component

@Component
class OrderMapper {

    fun toDomain(orderEntity: OrderEntity): Order {
        return Order(
            orderId = orderEntity.id!!,
            address = orderEntity.address,
            status = orderEntity.status,
            accountId = orderEntity.accountId,
            amount = orderEntity.amount,
            createdAt = orderEntity.createdAt!!,
            updatedAt = orderEntity.updatedAt!!,
        )
    }

    fun toNewEntity(orderToCreate: OrderToCreate): OrderEntity {
        return OrderEntity (
            amount = 0,
            status = OrderStatus.CREATED,
            accountId = orderToCreate.accountId,
            address = orderToCreate.address,
        )
    }
}