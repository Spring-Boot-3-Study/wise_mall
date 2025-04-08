package com.wise.mall.order.adapter.out.persistence

import com.wise.mall.order.adapter.out.persistence.entity.OrderEntity
import com.wise.mall.order.adapter.out.persistence.repository.OrderRepository
import com.wise.mall.order.domain.model.Order
import com.wise.mall.order.application.port.out.OrderPersistPort
import com.wise.mall.order.domain.model.OrderItem
import com.wise.mall.order.domain.model.OrderStatus
import com.wise.mall.order.domain.vo.OrderItemToCreate
import com.wise.mall.order.domain.vo.OrderToCreate
import com.wise.mall.product.adapter.out.persistence.repository.ProductRepository
import org.springframework.stereotype.Component

@Component
class OrderPersistAdapter(
    private val orderRepository: OrderRepository,
    private val productRepository: ProductRepository
): OrderPersistPort {
    override fun createOrder(order: OrderToCreate): Order {

        val entity = OrderEntity (
            totalPrice = 0,
            status = OrderStatus.PENDING,
            accountId = order.accountId,
            address = order.address,
        )

        val saved = orderRepository.save(entity)


        return Order(
            orderId = saved.orderId,
            accountId = saved.accountId,
            totalPrice = saved.totalPrice,
            status = saved.status,
            address = saved.address,
            createdAt = TODO(),
        )
    }

    override fun createOrderItem(order: OrderItemToCreate) {
        TODO("Not yet implemented")
    }

    override fun saveOrderItems(items: List<OrderItem>) {
        TODO("Not yet implemented")
    }

    override fun retrieveItems(orderItems: List<OrderItem>): List<OrderItem> {
        TODO("Not yet implemented")
    }
}