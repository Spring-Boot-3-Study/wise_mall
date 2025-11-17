package com.wisemall.monolithic.v1.order.core.usecase

import com.wisemall.monolithic.v1.order.api.dto.OrderToCreate
import com.wisemall.monolithic.v1.order.core.domain.Order
import com.wisemall.monolithic.v1.order.storage.entity.OrderItemEntity
import com.wisemall.monolithic.v1.order.storage.mapper.OrderMapper
import com.wisemall.monolithic.v1.order.storage.repository.OrderItemRepository
import com.wisemall.monolithic.v1.order.storage.repository.OrderRepository
import com.wisemall.monolithic.v1.product.adapter.out.persistence.repository.ProductRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class OrderCreateUseCase (
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
    private val productRepository: ProductRepository,
    private val orderMapper: OrderMapper,
) {


    @Transactional
    fun createOrder(order: OrderToCreate): Order {

        val entity = orderMapper.toNewEntity(order)
        val saved = orderRepository.save(entity)

        var total = 0

        order.orderItem.map { item ->
            val product = productRepository.findById(item.productId)
                .getOrNull() ?: throw RuntimeException("Product with id ${item.productId} not found")
            val subtotal = product.price*item.quantity
            total += subtotal

            OrderItemEntity(
                id = null,
                order = saved,
                product = product,
                price = product.price,
                quantity = item.quantity,
                subTotal = subtotal
            )
        }.forEach { item ->  orderItemRepository.save(item) }

        saved.amount = total

        return orderMapper.toDomain(saved)
    }


}