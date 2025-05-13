package com.wise.mall.delivery.persistence

import com.wise.mall.delivery.domain.model.Delivery
import com.wise.mall.delivery.dto.DeliveryToRegisterUpdate
import com.wise.mall.delivery.persistence.entity.DeliveryEntity
import com.wise.mall.delivery.persistence.mapper.DeliveryMapper
import com.wise.mall.delivery.persistence.repository.DeliveryRepository
import com.wise.mall.delivery.port.out.DeliveryPersistPort
import org.springframework.stereotype.Component

@Component
class DeliveryPersistAdapter(
    private val deliveryRepository: DeliveryRepository,
    private val deliveryMapper: DeliveryMapper
) : DeliveryPersistPort {

    override fun registerDelivery(dto: DeliveryToRegisterUpdate): Delivery {
        val entity = DeliveryEntity(
            deliveryId = dto.deliveryId,
            orderId = dto.orderId,
            courier = dto.courier,
            trackNumber = dto.trackNumber,
            status = dto.status
        )
        return deliveryMapper.toDomain(deliveryRepository.save(entity))
    }

    override fun getDelivery(deliveryId: Long): Delivery {
        val entity = deliveryRepository.findById(deliveryId)
            .orElseThrow { IllegalArgumentException("해당 배송이 존재하지 않습니다.") }
        return deliveryMapper.toDomain(entity)
    }

    override fun updateDeliveryStatus(dto: DeliveryToRegisterUpdate): Delivery {
        val entity = deliveryRepository.findById(dto.deliveryId)
            .orElseThrow { IllegalArgumentException("배송 정보가 존재하지 않습니다.") }

        entity.status = dto.status
        entity.courier = dto.courier
        entity.trackNumber = dto.trackNumber

        return deliveryMapper.toDomain(deliveryRepository.save(entity))
    }
}