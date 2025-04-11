package com.wise.mall.order.adapter.out.persistence

import com.wise.mall.order.adapter.out.OrderMapper
import com.wise.mall.order.adapter.out.persistence.entity.OrderEntity
import com.wise.mall.order.adapter.out.persistence.entity.OrderItemEntity
import com.wise.mall.order.adapter.out.persistence.repository.OrderItemRepository
import com.wise.mall.order.adapter.out.persistence.repository.OrderRepository
import com.wise.mall.order.domain.model.Order
import com.wise.mall.order.application.port.out.OrderPersistPort
import com.wise.mall.order.domain.model.OrderItem
import com.wise.mall.order.domain.model.OrderStatus
import com.wise.mall.order.domain.vo.OrderItemToCreate
import com.wise.mall.order.domain.vo.OrderToCreate
import com.wise.mall.product.adapter.out.persistence.repository.ProductRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class OrderPersistAdapter(
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
    private val productRepository: ProductRepository,
    private val orderMapper: OrderMapper,
): OrderPersistPort {

    @Transactional
    override fun createOrder(order: OrderToCreate): Order {

        val entity = orderMapper.toNewEntity(order)
        val saved = orderRepository.save(entity)

        var total = 0

        order.orderItem.map { item ->
            val product = productRepository.findById(item.productId)
                .getOrNull() ?: throw RuntimeException("Product with id ${item.productId} not found")
            val subtotal = product.price*item.quantity
            total += subtotal

            return@map OrderItemEntity(
                orderItemId = null,
                order = saved,
                product = product,
                price = product.price,
                quantity = item.quantity,
                subTotal = subtotal
            )
        }.forEach { item ->  orderItemRepository.save(item) }

        saved.totalPrice = total

        return orderMapper.toDomain(saved)
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