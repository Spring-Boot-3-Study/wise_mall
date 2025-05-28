package com.wise.mall.product.web

import com.wise.mall.common.response.ResponseDto
import com.wise.mall.product.port.`in`.ApprovalProductUseCase
import com.wise.mall.product.port.`in`.ProductUseCase
import com.wise.mall.product.port.`in`.command.*
import com.wise.mall.product.web.dto.request.CreateProductRequestDto
import com.wise.mall.product.web.dto.response.GetProductResponseDto
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Product RestController
 */
@RestController
@RequestMapping("/product")
class ProductController(
    private var approvalProductUseCase: ApprovalProductUseCase,
    private var productUseCase: ProductUseCase,
) {

    @PostMapping
    fun createProduct(
        @Valid @RequestBody createProductRequest: CreateProductRequestDto,
    ): ResponseEntity<ResponseDto<Map<String, Any>>> {

        productUseCase.createProduct(
            command = CreateProductCommand(
                name = createProductRequest.name,
                price = createProductRequest.price
            )
        )

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ProductAdapterResponse.PRODUCT_CREATE_PRODUCT_SUCCESS.toResponseDto())
    }

    @GetMapping("/{id}")
    fun getProduct(
        @PathVariable("id") id: Long,
    ): ResponseEntity<ResponseDto<GetProductResponseDto>> {

        val productDto = productUseCase.getProduct(command = GetProductCommand(id))

        val getProductResponseDto = GetProductResponseDto(
            id = productDto.id,
            name = productDto.name,
            price = productDto.price,
            createdAt = productDto.createdAt,
            updatedAt = productDto.updatedAt,
            isApprove = productDto.state == 1,
        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ProductAdapterResponse.PRODUCT_GET_PRODUCT_SUCCESS.toResponseDto(getProductResponseDto))
    }

    @GetMapping
    fun getProducts(
        @RequestParam("page") @Min(1) page: Int,
        @RequestParam("size") @Min(1) size: Int,
    ): ResponseEntity<ResponseDto<List<GetProductResponseDto>>> {

        val productDtos = productUseCase.getProducts(command = GetProductsCommand(page = page, size = size))

        val getProductResponseDtos = productDtos.map { productVo ->
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
            .status(HttpStatus.OK)
            .body(ProductAdapterResponse.PRODUCT_GET_PRODUCTS_SUCCESS.toResponseDto(getProductResponseDtos))
    }

    @PostMapping("/{id}")
    fun approveRequestProduct(
        @PathVariable("id") id: Long,
    ): ResponseEntity<ResponseDto<Map<String, Any>>> {

        approvalProductUseCase.approvalRequestProduct(command = ApprovalRequestProductCommand(id = id))

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ProductAdapterResponse.PRODUCT_APPROVE_REQUEST_PRODUCT_SUCCESS.toResponseDto())
    }

    @PutMapping("/approve/allow")
    fun approveAllowProduct(
        @RequestParam("id") id: Long,
    ): ResponseEntity<ResponseDto<Map<String, Any>>> {

        approvalProductUseCase.approvalAllowProduct(command = ApprovalAllowProductCommand(id = id))

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ProductAdapterResponse.PRODUCT_APPROVE_ALLOW_PRODUCT_SUCCESS.toResponseDto())
    }

    @PutMapping("/approve/deny")
    fun approveDenyProduct(
        @RequestParam("id") id: Long,
    ): ResponseEntity<ResponseDto<Map<String, Any>>> {

        approvalProductUseCase.approvalDenyProduct(command = ApprovalDenyProductCommand(id = id))

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ProductAdapterResponse.PRODUCT_APPROVE_DENY_PRODUCT_SUCCESS.toResponseDto())
    }
}