package com.wisemall.monolithic.v1.product.application.domain.model

import java.time.LocalDateTime

data class Product (

    val id: Long,

    var name: String,

    var price: Int,

    var state: Int,

    val createdAt: LocalDateTime,

    val updatedAt: LocalDateTime,
) {
    /**
     * 상품 등록 허가
     */
    fun approvalAllow() {
        this.state = 1
    }

    /**
     * 상품 등록 거부
     */
    fun approvalDeny() {
        this.state = -1
    }
}