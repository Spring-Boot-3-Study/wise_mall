package com.wise.mall.product.persistence.entity

import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener::class)
class ProductEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "price")
    var price: Int,

    @Column(name = "state")
    var state: Int,

) : BaseTimeEntity() {

    /**
     * 승인 여부 플래그 변경
     * 0  : 승인 대기
     * 1  : 승인 완료
     * -1 : 승인 거절
     */
    fun updateState(state: Int) {
        this.state = state
    }
}