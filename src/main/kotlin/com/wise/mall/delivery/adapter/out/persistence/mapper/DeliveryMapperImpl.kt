package com.wise.mall.delivery.adapter.out.persistence.mapper

import com.wise.mall.delivery.adapter.out.persistence.entity.DeliveryEntity
import com.wise.mall.delivery.application.domain.model.Delivery
import org.springframework.stereotype.Component

@Component
class DeliveryMapperImpl : DeliveryMapper {
    override fun toDomain(entity: DeliveryEntity): Delivery {
        return Delivery(
            deliveryId = entity.deliveryId,
            orderId = entity.orderId,
            courier = entity.courier,
            trackNumber = entity.trackNumber,
            status = entity.status,
            createdAt = entity.createdAt!!,
            updatedAt = entity.updatedAt!!
        )
    }

    override fun toEntity(domain: Delivery): DeliveryEntity {
        return DeliveryEntity(
            deliveryId = domain.deliveryId,
            orderId = domain.orderId,
            courier = domain.courier,
            trackNumber = domain.trackNumber,
            status = domain.status
        )
    }
} 