package com.wise.mall.order.persistence

import com.wise.mall.order.exception.OrderNotFoundException
import com.wise.mall.order.mapper.OrderItemMapper
import com.wise.mall.order.mapper.OrderMapper
import com.wise.mall.order.model.Order
import com.wise.mall.order.model.OrderItem
import com.wise.mall.order.persistence.entity.OrderItemEntity
import com.wise.mall.order.persistence.repository.OrderItemRepository
import com.wise.mall.order.persistence.repository.OrderRepository
import com.wise.mall.order.port.out.OrderPersistPort
import com.wise.mall.order.vo.OrderToCreate
import com.wise.mall.product.persistence.repository.ProductRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrElse
import kotlin.jvm.optionals.getOrNull

@Component
class OrderPersistAdapter(
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
    private val productRepository: ProductRepository,
    private val orderMapper: OrderMapper,
    private val orderItemMapper: OrderItemMapper
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

    override fun getOrderById(orderId: Long): Order {
        val order = orderRepository.findById(orderId).getOrElse { throw OrderNotFoundException(orderId) }
        return orderMapper.toDomain(order)
    }

    override fun getOrderItemsByOrderId(orderId: Long): List<OrderItem> {
        return orderItemRepository.findByOrderId(orderId).map { orderItemMapper.toDomain(it) }
    }


}