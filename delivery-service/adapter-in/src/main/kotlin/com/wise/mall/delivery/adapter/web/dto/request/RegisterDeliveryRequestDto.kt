package com.wise.mall.delivery.adapter.web.dto.request

import com.wise.mall.delivery.adapter.web.util.CourierGenerator
import com.wise.mall.delivery.adapter.web.util.TrackingNumberGenerator

data class RegisterDeliveryRequestDto(
    val orderId: String,
    val courier: String = CourierGenerator.generate(),
    val trackNumber: String = TrackingNumberGenerator.generate()
)