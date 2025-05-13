package com.wise.mall.delivery.persistence.mapper

import com.wise.mall.delivery.domain.model.Delivery
import com.wise.mall.delivery.persistence.entity.DeliveryEntity

interface DeliveryMapper {
    fun toDomain(entity: DeliveryEntity): Delivery
    fun toEntity(domain: Delivery): DeliveryEntity
} 