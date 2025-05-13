package com.wise.mall.order.persistence.entity

import com.wise.mall.common.entity.AddressData
import com.wise.mall.common.entity.BaseTimeEntity
import com.wise.mall.order.model.OrderStatus
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
    val address: AddressData,

    var totalPrice: Int,

    @Enumerated(EnumType.STRING)
    val status: OrderStatus

): BaseTimeEntity() {

}