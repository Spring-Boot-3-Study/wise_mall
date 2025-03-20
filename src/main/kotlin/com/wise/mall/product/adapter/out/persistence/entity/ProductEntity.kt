package com.wise.mall.product.adapter.out.persistence.entity

import com.wise.mall.global.entity.BaseTimeEntity
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener::class)
class ProductEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "price")
    val price: Int,

    @Column(name = "state")
    val state: Int,

) : BaseTimeEntity()