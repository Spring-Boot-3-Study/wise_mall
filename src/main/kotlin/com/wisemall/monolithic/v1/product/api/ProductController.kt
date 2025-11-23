package com.wisemall.monolithic.v1.product.api

import com.wisemall.monolithic.v1.global.response.ResponseDto
import com.wisemall.monolithic.v1.product.api.dto.request.CreateProductRequestDto
import com.wisemall.monolithic.v1.product.api.dto.response.GetProductResponseDto
import com.wisemall.monolithic.v1.product.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/product")
class ProductController(
    private val productService: ProductService,
) {

    /**
     * 상품 등록
     *
     * @param createProductRequest 상품 등록 요청 정보
     */
    @PostMapping
    fun createProduct(
        @RequestBody createProductRequest: CreateProductRequestDto
    ): ResponseEntity<ResponseDto<Map<String, Any>>> {

        productService.createProduct(
            name = createProductRequest.name,
            price = createProductRequest.price,
        )

        return ResponseEntity
            .status(ProductResponse.PRODUCT_CREATE_PRODUCT_SUCCESS.getHttpStatus())
            .body(ProductResponse.PRODUCT_CREATE_PRODUCT_SUCCESS.toResponseDto())
    }

    /**
     * 상품 단건 조회
     *
     * @param id 상품 ID
     */
    @GetMapping("/{id}")
    fun getProduct(
        @PathVariable("id") id: Long
    ): ResponseEntity<ResponseDto<GetProductResponseDto>> {

        val productVo = productService.getProduct(id = id)

        val getProductResponseDto = GetProductResponseDto(
            id = productVo.id,
            name = productVo.name,
            price = productVo.price,
            createdAt = productVo.createdAt,
            updatedAt = productVo.updatedAt,
            isApprove = productVo.state == 1,
        )

        return ResponseEntity
            .status(ProductResponse.PRODUCT_GET_PRODUCT_SUCCESS.getHttpStatus())
            .body(ProductResponse.PRODUCT_GET_PRODUCT_SUCCESS.toResponseDto(getProductResponseDto))
    }

    /**
     * 상품 다건 조회
     *
     * @param page 페이지
     * @param size 사이즈
     */
    @GetMapping
    fun getProducts(
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int
    ): ResponseEntity<ResponseDto<List<GetProductResponseDto>>> {

        val productVos = productService.getProducts(page = page, size = size)

        val getProductResponseDtos = productVos.map { productVo ->
            GetProductResponseDto(
                id = productVo.id,
                name = productVo.name,
                price = productVo.price,
                createdAt = productVo.createdAt,
                updatedAt = productVo.updatedAt,
                isApprove = productVo.state == 1,
            )
        }

        return ResponseEntity
            .status(ProductResponse.PRODUCT_GET_PRODUCTS_SUCCESS.getHttpStatus())
            .body(ProductResponse.PRODUCT_GET_PRODUCTS_SUCCESS.toResponseDto(getProductResponseDtos))
    }

    /**
     * 상품 판매 승인 요청
     *
     * @param id 상품 ID
     */
    @PostMapping("/{id}")
    fun approveRequestProduct(
        @PathVariable("id") id: Long
    ): ResponseEntity<ResponseDto<Map<String, Any>>> {

        productService.approvalRequestProduct(id = id)

        return ResponseEntity
            .status(ProductResponse.PRODUCT_APPROVE_REQUEST_PRODUCT_SUCCESS.getHttpStatus())
            .body(ProductResponse.PRODUCT_APPROVE_REQUEST_PRODUCT_SUCCESS.toResponseDto())
    }

    /**
     * 상품 판매 요청 승인
     *
     * @param id 상품 ID
     */
    @PutMapping("/approve/allow")
    fun approveAllowProduct(
        @RequestParam("id") id: Long
    ): ResponseEntity<ResponseDto<Map<String, Any>>> {

        productService.approvalAllowProduct(id = id)

        return ResponseEntity
            .status(ProductResponse.PRODUCT_APPROVE_ALLOW_PRODUCT_SUCCESS.getHttpStatus())
            .body(ProductResponse.PRODUCT_APPROVE_ALLOW_PRODUCT_SUCCESS.toResponseDto())
    }

    /**
     * 상품 판매 요청 거절
     *
     * @param id 상품 ID
     */
    @PutMapping("/approve/deny")
    fun approveDenyProduct(
        @RequestParam("id") id: Long
    ): ResponseEntity<ResponseDto<Map<String, Any>>> {

        productService.approvalDenyProduct(id = id)

        return ResponseEntity
            .status(ProductResponse.PRODUCT_APPROVE_DENY_PRODUCT_SUCCESS.getHttpStatus())
            .body(ProductResponse.PRODUCT_APPROVE_DENY_PRODUCT_SUCCESS.toResponseDto())
    }
}