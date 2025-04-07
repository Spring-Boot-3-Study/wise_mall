package com.wise.mall.order.application.port.out

import com.wise.mall.order.application.domain.Order

interface OrderPersistPort {
    fun createOrder(order: Order): Order
}