package com.wise.mall.product.web.dto.request

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class CreateProductRequestDto(

    @field: NotBlank
    var name: String,

    @field: Min(0)
    var price: Int,
)
