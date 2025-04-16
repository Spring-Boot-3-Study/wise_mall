package com.wise.mall.delivery.adapter.out.persistence.mapper

import com.wise.mall.delivery.adapter.out.persistence.entity.DeliveryEntity
import com.wise.mall.delivery.application.domain.model.Delivery

interface DeliveryMapper {
    fun toDomain(entity: DeliveryEntity): Delivery
    fun toEntity(domain: Delivery): DeliveryEntity
} 