package com.wise.mall.order.application.port.out

import com.wise.mall.order.domain.model.Order
import com.wise.mall.order.domain.model.OrderItem
import com.wise.mall.order.domain.vo.OrderItemToCreate
import com.wise.mall.order.domain.vo.OrderToCreate

interface OrderPersistPort {
    fun createOrder(order: OrderToCreate): Order
    fun createOrderItem(order: OrderItemToCreate)
    fun saveOrderItems(items: List<OrderItem>)
    fun retrieveItems(orderItems: List<OrderItem>): List<OrderItem>
}