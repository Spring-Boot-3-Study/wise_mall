package com.wise.mall.delivery.adapter.`in`.web;

import com.wise.mall.delivery.adapter.`in`.web.dto.request.simulation.RegistShippingRequestDto
import com.wise.mall.delivery.adapter.`in`.web.dto.request.simulation.UpdateShippingRequestDto
import com.wise.mall.delivery.application.domain.model.simulation.Shipping
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.ConcurrentHashMap
/*
주문 완료 시 택배사에 접수 로직 (/delivery/simulation/register)
접수 후 DeliveryController에서 배송조회,

 */
@RestController
@RequestMapping("/delivery/simulation")
class DeliverySimulationController {

    private val shippingStorage = ConcurrentHashMap<String, Shipping>()

    @PostMapping("/register")
    fun register(@RequestBody request: RegistShippingRequestDto): ResponseEntity<String> {
        val trackingNumber = UUID.randomUUID().toString()
        val info = Shipping(
            trackingNumber = trackingNumber,
            orderId = request.orderId,
            status = "접수완료",
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
        shippingStorage[trackingNumber] = info
        return ResponseEntity.ok(trackingNumber)
    }

    @GetMapping("/{trackingNumber}")
    fun getStatus(@PathVariable trackingNumber: String): ResponseEntity<Shipping> {
        val info = shippingStorage[trackingNumber] ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(info)
    }

    @PostMapping("/update")
    fun updateStatus(@RequestBody request: UpdateShippingRequestDto): ResponseEntity<Void> {
        val info = shippingStorage[request.trackingNumber] ?: return ResponseEntity.notFound().build()
        info.status = request.status
        info.updatedAt = LocalDateTime.now()
        return ResponseEntity.ok().build()
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<Shipping>> {
        return ResponseEntity.ok(shippingStorage.values.toList())
    }
}

