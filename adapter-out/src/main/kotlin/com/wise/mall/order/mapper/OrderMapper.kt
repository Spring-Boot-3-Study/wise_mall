package com.wise.mall.order.mapper

import com.wise.mall.common.entity.AddressData
import com.wise.mall.common.vo.Address
import com.wise.mall.order.model.Order
import com.wise.mall.order.model.OrderStatus
import com.wise.mall.order.persistence.entity.OrderEntity
import com.wise.mall.order.vo.OrderToCreate
import org.springframework.stereotype.Component

@Component
class OrderMapper {

    fun toDomain(orderEntity: OrderEntity): Order {
        return Order(
            orderId = orderEntity.id!!,
            address = Address(
                name = orderEntity.address.name,
                phoneNumber = orderEntity.address.phoneNumber,
                postalCode = orderEntity.address.postalCode,
                address1 = orderEntity.address.address1,
                address2 = orderEntity.address.address2,
            ),
            status = orderEntity.status,
            accountId = orderEntity.accountId,
            totalPrice = orderEntity.totalPrice,
            createdAt = orderEntity.createdAt!!,
            updatedAt = orderEntity.updatedAt!!,
        )
    }

    fun toNewEntity(orderToCreate: OrderToCreate): OrderEntity {
        return OrderEntity(
            totalPrice = 0,
            status = OrderStatus.PENDING,
            accountId = orderToCreate.accountId,
            address = AddressData(
                    name = orderToCreate.address.name,
                    phoneNumber = orderToCreate.address.phoneNumber,
                    postalCode = orderToCreate.address.postalCode,
                    address1 = orderToCreate.address.address1,
                    address2 = orderToCreate.address.address2,
                )
        )
    }
}