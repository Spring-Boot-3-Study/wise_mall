package com.wise.mall.delivery.port.out

import com.wise.mall.delivery.domain.model.Delivery
import com.wise.mall.delivery.dto.DeliveryToRegisterUpdate

interface DeliveryPersistPort {
    fun registerDelivery(dto: DeliveryToRegisterUpdate): Delivery

    fun getDelivery(deliveryId: Long): Delivery

    fun updateDeliveryStatus(dto: DeliveryToRegisterUpdate) : Delivery
}