package com.wise.mall.order.port.out

import com.wise.mall.order.model.Order
import com.wise.mall.order.model.OrderItem
import com.wise.mall.order.vo.OrderToCreate

interface OrderPersistPort {
    fun createOrder(order: OrderToCreate): Order
    fun getOrderById(orderId: Long): Order
    fun getOrderItemsByOrderId(orderId: Long): List<OrderItem>
}