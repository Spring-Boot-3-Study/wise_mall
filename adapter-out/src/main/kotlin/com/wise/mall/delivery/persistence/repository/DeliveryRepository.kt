package com.wise.mall.delivery.persistence.repository

import com.wise.mall.delivery.persistence.entity.DeliveryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DeliveryRepository : JpaRepository<DeliveryEntity, Long> {
    fun findByOrderId(orderId: String): DeliveryEntity?
}