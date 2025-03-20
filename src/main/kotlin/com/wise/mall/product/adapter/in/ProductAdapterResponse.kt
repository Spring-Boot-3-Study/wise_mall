package com.wise.mall.product.adapter.`in`

import com.wise.mall.global.response.Response

enum class ProductAdapterResponse(
    private val code: Int,
    private val message: String
) : Response {

    PRODUCT_CREATE_PRODUCT_SUCCESS(100, "상품 생성에 성공했습니다."),
    PRODUCT_GET_PRODUCT_SUCCESS(101, "상품 조회에 성공했습니다."),
    PRODUCT_GET_PRODUCTS_SUCCESS(102, "상품 목록 조회에 성공했습니다."),
    PRODUCT_APPROVE_REQUEST_PRODUCT_SUCCESS(103, "상품 등록 승인 요청에 성공했습니다."),
    PRODUCT_APPROVE_ALLOW_PRODUCT_SUCCESS(104, "상품 등록 승인에 성공했습니다."),
    PRODUCT_APPROVE_DENY_PRODUCT_SUCCESS(105, "상품 등록 거절에 성공했습니다."),
    ;

    override fun getCode(): Int = this.code
    override fun getMessage(): String = this.message
}