package com.wisemall.monolithic.v1.delivery.storage.repository

import com.wisemall.monolithic.v1.delivery.storage.entity.DeliveryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DeliveryRepository: JpaRepository<DeliveryEntity, Long> {

}