package com.wisemall.monolithic.v1.payment.application.application

import com.wisemall.monolithic.v1.order.persistence.repository.OrderJpaRepository
import com.wisemall.monolithic.v1.payment.application.domain.Order
import com.wisemall.monolithic.v1.payment.application.exception.OrderNotValidException
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class PaymentValidator (
    private val orderRepository: OrderJpaRepository,
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
        requireNotNull(order) { OrderNotValidException() }
        require(order.accountId == accountId) { OrderNotValidException() }
        require(order.status == "PENDING") { OrderNotValidException() }
        require(order.amount == amount) { OrderNotValidException() }
    }
}