package com.wise.mall.order.persistence.entity

import com.wise.mall.global.entity.BaseTimeEntity
import com.wise.mall.product.adapter.out.persistence.entity.ProductEntity
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

): BaseTimeEntity() {

}