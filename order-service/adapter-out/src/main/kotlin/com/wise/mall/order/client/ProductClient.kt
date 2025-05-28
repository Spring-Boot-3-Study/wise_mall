package com.wise.mall.order.client

import com.wise.mall.common.response.ResponseDto
import com.wise.mall.product.model.Product
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(
    name = "product-service",
    url = "http://localhost:8085"
)
interface ProductClient {

    @GetMapping("/product/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ResponseDto<Product>>
}