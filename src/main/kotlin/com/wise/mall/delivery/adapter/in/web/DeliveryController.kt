package com.wise.mall.delivery.adapter.`in`.web

import com.wise.mall.delivery.adapter.`in`.web.dto.request.RegisterDeliveryRequestDto
import com.wise.mall.delivery.application.domain.model.DeliveryStatus
import com.wise.mall.delivery.application.port.`in`.DeliveryUseCase
import com.wise.mall.delivery.application.port.`in`.command.RegisterDeliveryCommand
import com.wise.mall.delivery.application.port.`in`.command.UpdateDeliveryStatusCommand
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/delivery")
class DeliveryController(
    private val deliveryUseCase: DeliveryUseCase
) {
    @PostMapping
    fun registerDelivery(@RequestBody registerDeliveryRequestDto: RegisterDeliveryRequestDto): ResponseEntity<Any> {
        val registerDeliveryDto = deliveryUseCase.registerDelivery(
            command = RegisterDeliveryCommand(
                orderId = registerDeliveryRequestDto.orderId,
                courier = registerDeliveryRequestDto.courier,
                trackNumber = registerDeliveryRequestDto.trackNumber
            )
        )
        return ResponseEntity.ok(registerDeliveryDto)
    }

    @GetMapping("/{id}")
    fun getDelivery(@PathVariable id: Long): ResponseEntity<Any> {
        val deliveryResponseDto = deliveryUseCase.getDelivery(id)
        return ResponseEntity.ok(deliveryResponseDto)
    }

    @PutMapping("/{id}/status")
    fun updateStatus(@PathVariable id: Long, @RequestParam status: DeliveryStatus): ResponseEntity<Any> {
        val updateDeliveryDto = deliveryUseCase.updateDeliveryStatus(
            command = UpdateDeliveryStatusCommand(
                deliveryId = id,
                status = status
            )
        )
        return ResponseEntity.ok(updateDeliveryDto)
    }
}