package com.wisemall.monolithic.v1.product.api

import com.wisemall.monolithic.v1.global.response.Response_
import org.springframework.http.HttpStatus

enum class ProductResponse(
    private val httpStatus: HttpStatus,
    private val code: Int,
    private val message: String
) : Response_ {

    PRODUCT_CREATE_PRODUCT_SUCCESS(HttpStatus.CREATED, 100, "상품 생성에 성공했습니다."),
    PRODUCT_GET_PRODUCT_SUCCESS(HttpStatus.OK, 101, "상품 조회에 성공했습니다."),
    PRODUCT_GET_PRODUCTS_SUCCESS(HttpStatus.OK, 102, "상품 목록 조회에 성공했습니다."),
    PRODUCT_APPROVE_REQUEST_PRODUCT_SUCCESS(HttpStatus.OK, 103, "상품 등록 승인 요청에 성공했습니다."),
    PRODUCT_APPROVE_ALLOW_PRODUCT_SUCCESS(HttpStatus.OK, 104, "상품 등록 승인에 성공했습니다."),
    PRODUCT_APPROVE_DENY_PRODUCT_SUCCESS(HttpStatus.OK, 105, "상품 등록 거절에 성공했습니다."),
    ;

    override fun getHttpStatus(): HttpStatus = this.httpStatus
    override fun getCode(): Int = this.code
    override fun getMessage(): String = this.message
}