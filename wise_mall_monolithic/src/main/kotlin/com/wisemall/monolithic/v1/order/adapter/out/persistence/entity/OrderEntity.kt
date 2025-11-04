package com.wise.mall.v1.order.adapter.out.persistence.entity

import com.wise.mall.v1.global.entity.BaseTimeEntity
import com.wise.mall.v1.global.vo.Address
import com.wise.mall.v1.order.domain.model.OrderStatus
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener::class)
class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val accountId: String,

    @Embedded
    val address: Address,

    var totalPrice: Int,

    @Enumerated(EnumType.STRING)
    val status: OrderStatus

): BaseTimeEntity() {

}