package com.wise.mall.v1.order.application.port.out

import com.wise.mall.v1.order.domain.model.Order
import com.wise.mall.v1.order.domain.model.OrderItem
import com.wise.mall.v1.order.domain.vo.OrderToCreate

interface OrderPersistPort {
    fun createOrder(order: OrderToCreate): Order
    fun getOrderById(orderId: Long): Order
    fun getOrderItemsByOrderId(orderId: Long): List<OrderItem>
}