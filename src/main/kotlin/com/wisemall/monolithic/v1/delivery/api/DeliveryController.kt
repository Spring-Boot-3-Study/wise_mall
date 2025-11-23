package com.wisemall.monolithic.v1.delivery.api

import com.wisemall.monolithic.v1.delivery.api.dto.DeliveryCreateRequest
import com.wisemall.monolithic.v1.delivery.core.service.DeliveryCreateUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/orders/delivery")
class DeliveryController (
    private val deliveryCreateUseCase: DeliveryCreateUseCase,
) {

    @PostMapping
    fun registerDelivery(@RequestBody request: DeliveryCreateRequest) {
        deliveryCreateUseCase.execute(
            orderId = request.orderId,
            carrier = request.carrier,
            trackNumber = request.trackNumber
        )
    }

    @PostMapping
    fun registerDelivery(@RequestBody requestList: List<DeliveryCreateRequest>) {
        requestList.forEach { request ->
            deliveryCreateUseCase.execute(
                orderId = request.orderId,
                carrier = request.carrier,
                trackNumber = request.trackNumber
            )
        }
    }

}