package com.wisemall.monolithic.v1.global.enums

enum class OrderStatus(val description: String) {
    CREATED("주문 접수"),
    PAID("결제 완료"),
    PROCESSING("상품 준비 중"),
    PICKED_UP("출고 완료"),
    IN_TRANSIT("배송 중"),
    DELIVERED("배송 완료"),
    CONFIRM("주문 취소");

    override fun toString(): String = description
}