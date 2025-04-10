package com.wise.mall.delivery.application.port.out

import com.wise.mall.delivery.application.domain.model.Delivery
import com.wise.mall.delivery.application.vo.UpdateDeliveryStatusVo

interface DeliveryPersistPort {
    fun registerDelivery(delivery: Delivery)

    fun getDelivery(deliveryId: Long): Delivery
}