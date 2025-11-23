package com.wisemall.monolithic.v1.payment.application.application

import com.wisemall.monolithic.v1.order.storage.repository.OrderRepository
import com.wisemall.monolithic.v1.payment.application.domain.Order
import com.wisemall.monolithic.v1.payment.application.exception.OrderInvalidException
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class PaymentValidator (
    private val orderRepository: OrderRepository,
) {
    fun getOrder(orderId: Long): Order? {
        return orderRepository.findById(orderId).getOrNull()?.let {
            Order(
                orderId = it.id!!,
                accountId = it.accountId,
                amount = it.amount,
                status = it.status.toString(),
            )
        }
    }

    fun valid(
        orderId: Long,
        accountId: Long,
        amount: Int
    ) {
        val order = getOrder(orderId)
        requireNotNull(order) { OrderInvalidException() }
        require(order.accountId == accountId) { OrderInvalidException() }
        require(order.status == "PENDING") { OrderInvalidException() }
        require(order.amount == amount) { OrderInvalidException() }
    }
}