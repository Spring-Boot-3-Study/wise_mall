package com.wisemall.monolithic.v1.product.adapter.`in`.web.exception

import com.wisemall.monolithic.v1.global.exception.ErrorException
import com.wisemall.monolithic.v1.global.response.ResponseDto
import com.wisemall.monolithic.v1.product.adapter.`in`.web.ProductController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * 전역 예외 처리 핸들러
 */
@ControllerAdvice(basePackageClasses = [ ProductController::class ])
class ProductExceptionHandler {

    @ExceptionHandler(ErrorException::class)
    fun handleErrorException(errorException: ErrorException): ResponseEntity<ResponseDto<Map<String, Any>>> {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ResponseDto(
                    code = errorException.errorCode.getCode(),
                    message = errorException.errorCode.getMessage(),
                    result = errorException.result
                )
            )
    }
}