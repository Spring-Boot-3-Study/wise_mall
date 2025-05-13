package com.wise.mall.domain.order

enum class OrderStatus(val description: String) {
    PENDING("결제 대기"),
    PAID("결제 완료"),
    PROCESSING("상품 준비 중"),
    PACKING("포장 중"),
    SHIPPING("배송 중"),
    SHIPPED("출고 완료"),
    DELIVERED("배송 완료"),
    CANCELLED("주문 취소"),
    REFUNDED("환불 완료"),
    RETURN_REQUESTED("반품 요청"),
    RETURNED("반품 완료"),
    FAILED("결제 실패");

    override fun toString(): String = description
}