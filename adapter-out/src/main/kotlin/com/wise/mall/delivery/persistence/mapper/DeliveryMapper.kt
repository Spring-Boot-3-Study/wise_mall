package com.wise.mall.delivery.persistence.mapper

import com.wise.mall.delivery.persistence.entity.DeliveryEntity
import com.wise.mall.delivery.application.domain.model.Delivery

interface DeliveryMapper {
    fun toDomain(entity: DeliveryEntity): Delivery
    fun toEntity(domain: Delivery): DeliveryEntity
} 