package com.wise.mall.order.persistence.entity

import com.wise.mall.order.entity.BaseTimeEntity
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

    val productId: Long,

    // 구매 당시 가격
    val price: Int,
    val quantity: Int,

    val subTotal: Int

): BaseTimeEntity() {

}