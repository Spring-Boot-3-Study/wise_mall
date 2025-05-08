package com.wise.mall.product.web

import com.wise.mall.global.response.ResponseDto
import com.wise.mall.product.web.dto.request.CreateProductRequestDto
import com.wise.mall.product.web.dto.response.GetProductResponseDto
import com.wise.mall.product.application.port.`in`.ApprovalProductUseCase
import com.wise.mall.product.application.port.`in`.ProductUseCase
import com.wise.mall.product.application.port.`in`.command.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Product RestController
 */
@RestController
@RequestMapping("/product")
class ProductController(
    private val approvalProductUseCase: ApprovalProductUseCase,
    private val productUseCase: ProductUseCase,
) {

    @PostMapping
    fun createProduct(@RequestBody createProductRequest: CreateProductRequestDto): ResponseEntity<ResponseDto<Map<String, Any>>> {

        productUseCase.createProduct(
            command = CreateProductCommand(
                name = createProductRequest.name,
                price = createProductRequest.price)
        )

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ProductAdapterResponse.PRODUCT_CREATE_PRODUCT_SUCCESS.toResponseDto())
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable("id") id: Long): ResponseEntity<ResponseDto<GetProductResponseDto>> {

        val productVo = productUseCase.getProduct(command = GetProductCommand(id))

        val getProductResponseDto = GetProductResponseDto(
            id = productVo.id,
            name = productVo.name,
            price = productVo.price,
            createdAt = productVo.createdAt,
            updatedAt = productVo.updatedAt,
            isApprove = productVo.state == 1,
        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ProductAdapterResponse.PRODUCT_GET_PRODUCT_SUCCESS.toResponseDto(getProductResponseDto))
    }

    @GetMapping
    fun getProducts(@RequestParam("page") page: Int, @RequestParam("size") size: Int): ResponseEntity<ResponseDto<List<GetProductResponseDto>>> {

        val productVos = productUseCase.getProducts(command = GetProductsCommand(page = page, size = size))

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
            .status(HttpStatus.OK)
            .body(ProductAdapterResponse.PRODUCT_GET_PRODUCTS_SUCCESS.toResponseDto(getProductResponseDtos))
    }

    @PostMapping("/{id}")
    fun approveRequestProduct(@PathVariable("id") id: Long): ResponseEntity<ResponseDto<Map<String, Any>>> {

        approvalProductUseCase.approvalRequestProduct(command = ApprovalRequestProductCommand(id = id))

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ProductAdapterResponse.PRODUCT_APPROVE_REQUEST_PRODUCT_SUCCESS.toResponseDto())
    }

    @PutMapping("/approve/allow")
    fun approveAllowProduct(@RequestParam("id") id: Long): ResponseEntity<ResponseDto<Map<String, Any>>> {

        approvalProductUseCase.approvalAllowProduct(command = ApprovalAllowProductCommand(id = id))

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ProductAdapterResponse.PRODUCT_APPROVE_ALLOW_PRODUCT_SUCCESS.toResponseDto())
    }

    @PutMapping("/approve/deny")
    fun approveDenyProduct(@RequestParam("id") id: Long): ResponseEntity<ResponseDto<Map<String, Any>>> {

        approvalProductUseCase.approvalDenyProduct(command = ApprovalDenyProductCommand(id = id))

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ProductAdapterResponse.PRODUCT_APPROVE_DENY_PRODUCT_SUCCESS.toResponseDto())
    }
}