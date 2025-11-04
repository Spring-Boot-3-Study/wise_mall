package com.wisemall.monolithic.v1.order.persistence.entity

import com.wisemall.monolithic.v1.global.entity.BaseEntity
import com.wisemall.monolithic.v1.global.vo.Address
import com.wisemall.monolithic.v1.order.core.enums.OrderStatus
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

): BaseEntity() {

}