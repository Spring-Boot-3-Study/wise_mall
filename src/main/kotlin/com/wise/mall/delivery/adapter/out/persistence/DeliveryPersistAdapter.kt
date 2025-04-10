package com.wise.mall.delivery.adapter.out.persistence

import com.wise.mall.delivery.adapter.out.persistence.repository.DeliveryRepository
import com.wise.mall.delivery.application.domain.model.Delivery
import com.wise.mall.delivery.application.port.out.DeliveryPersistPort
import com.wise.mall.delivery.application.vo.UpdateDeliveryStatusVo
import org.springframework.stereotype.Component

@Component
class DeliveryPersistAdapter(
    private val deliveryRepository: DeliveryRepository
) : DeliveryPersistPort {

    override fun registerDelivery(delivery: Delivery) {
        deliveryRepository.save(delivery.toEntity())
    }

    override fun getDelivery(deliveryId: Long): Delivery {
        val entity = deliveryRepository.findById(deliveryId)
            .orElseThrow { IllegalArgumentException("해당 배송이 존재하지 않습니다.") }
        return entity.toDomain()
    }

    override fun updateDeliveryStatus(delivery: Delivery) {
        deliveryRepository.save(delivery.toEntity())
    }
}