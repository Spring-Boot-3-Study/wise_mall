package com.wise.mall.order.application.port.out

import com.wise.mall.order.domain.model.Order
import com.wise.mall.order.domain.model.OrderItem
import com.wise.mall.order.domain.vo.OrderToCreate

interface OrderPersistPort {
    fun createOrder(order: OrderToCreate): Order
    fun getOrderById(orderId: Long): Order
    fun getOrderItemsByOrderId(orderId: Long): List<OrderItem>
}