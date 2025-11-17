package com.wisemall.monolithic.v1.global.enums

enum class PaymentStatus(
    val description: String,
) {
    PENDING("결제 대기"),
//    REQUESTED,
    SUCCESS("결제 성공"),
    FAILED("결제 실패"),
//    CANCELED
}