package com.wise.mall.delivery.adapter.`in`.web

import com.wise.mall.delivery.adapter.`in`.web.dto.request.RegisterDeliveryRequestDto
import com.wise.mall.delivery.application.domain.model.Delivery
import com.wise.mall.delivery.application.domain.model.DeliveryStatus
import com.wise.mall.delivery.application.port.`in`.DeliveryUseCase
import com.wise.mall.delivery.application.port.`in`.command.RegisterDeliveryCommand
import com.wise.mall.delivery.application.port.`in`.command.UpdateDeliveryStatusCommand
import com.wise.mall.global.response.ResponseDto
import com.wise.mall.product.adapter.`in`.web.dto.response.GetProductResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/delivery")
class DeliveryController(
    private val deliveryUseCase: DeliveryUseCase
) {
    @PostMapping
    fun registerDelivery(@RequestBody registerDeliveryRequestDto: RegisterDeliveryRequestDto): ResponseEntity<Any> {
        val register = deliveryUseCase.registerDelivery(
            command = RegisterDeliveryCommand(
                orderId = registerDeliveryRequestDto.orderId,
                courier = registerDeliveryRequestDto.courier,
                trackNumber = registerDeliveryRequestDto.trackNumber
            )
        )
        return ResponseEntity.ok(register)
    }

    @GetMapping("/{id}")
    fun getDelivery(@PathVariable id: Long): ResponseEntity<Any> {
        val delivery = deliveryUseCase.getDelivery(id)
        return ResponseEntity.ok(delivery)
    }

    @PutMapping("/{id}/status")
    fun updateStatus(@PathVariable id: Long, @RequestParam status: DeliveryStatus): ResponseEntity<Any> {
        val update = deliveryUseCase.updateDeliveryStatus(
            command = UpdateDeliveryStatusCommand(
                deliveryId = id,
                status = status
            )
        )
        return ResponseEntity.ok(update)
    }
}