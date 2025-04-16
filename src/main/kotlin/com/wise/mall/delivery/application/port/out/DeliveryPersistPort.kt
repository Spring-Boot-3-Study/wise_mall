package com.wise.mall.delivery.application.port.out

import com.wise.mall.delivery.application.domain.model.Delivery
import com.wise.mall.delivery.application.dto.DeliveryToRegisterUpdate

interface DeliveryPersistPort {
    fun registerDelivery(dto: DeliveryToRegisterUpdate): Delivery

    fun getDelivery(deliveryId: Long): Delivery

    fun updateDeliveryStatus(dto: DeliveryToRegisterUpdate) : Delivery
}