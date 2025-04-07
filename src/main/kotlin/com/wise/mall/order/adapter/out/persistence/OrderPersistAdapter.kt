package com.wise.mall.order.adapter.out.persistence

import com.wise.mall.order.adapter.out.persistence.entity.OrderEntity
import com.wise.mall.order.adapter.out.persistence.entity.OrderItemEntity
import com.wise.mall.order.adapter.out.persistence.repository.OrderRepository
import com.wise.mall.order.application.domain.Order
import com.wise.mall.order.application.port.out.OrderPersistPort
import com.wise.mall.product.adapter.out.persistence.repository.ProductRepository
import org.springframework.stereotype.Component

@Component
class OrderPersistAdapter(
    private val orderRepository: OrderRepository,
    private val productRepository: ProductRepository
): OrderPersistPort {
    override fun createOrder(order: Order): Order {

        val orderEntity = OrderEntity(
            orderItems = order.orderItems.map { item ->
                OrderItemEntity(
                    product = productRepository.findById(order.orderId).get(),
                    price = item.price,
                    quantity = item.quantity,
                    subTotal = item.subtotal
                )
            }.toList(),
            totalPrice = order.totalPrice,
            status = order.status,


            )
        orderRepository.save(orderEntity)
        return order
    }
}