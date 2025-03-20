package com.wise.mall.product.application.port.out

import com.wise.mall.product.application.port.out.vo.ProductVo

interface ProductReadPort {

    fun getProduct(id: Long): ProductVo

    fun getProducts(page: Int, size: Int): List<ProductVo>
}