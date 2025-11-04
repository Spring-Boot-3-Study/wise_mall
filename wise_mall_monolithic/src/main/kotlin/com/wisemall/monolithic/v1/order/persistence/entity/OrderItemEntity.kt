package com.wisemall.monolithic.v1.order.adapter.out.persistence.entity

import com.wisemall.monolithic.v1.global.entity.BaseEntity
import com.wisemall.monolithic.v1.order.persistence.entity.OrderEntity
import com.wisemall.monolithic.v1.product.adapter.out.persistence.entity.ProductEntity
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener


@Entity
@Table(name = "order_items")
@EntityListeners(AuditingEntityListener::class)
class OrderItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderItemId: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    val order: OrderEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "product_id")
    val product: ProductEntity,

    // 구매 당시 가격
    val price: Int,
    val quantity: Int,

    val subTotal: Int

): BaseEntity() {

}