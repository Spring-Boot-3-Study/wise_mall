package com.wisemall.monolithic.v1.product.api

import com.wisemall.monolithic.v1.global.response.ResponseDto
import com.wisemall.monolithic.v1.product.exception.InvalidPriceException
import com.wisemall.monolithic.v1.product.exception.NotExistsProductException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * 전역 예외 처리 핸들러
 */
@ControllerAdvice(basePackageClasses = [ ProductController::class ])
class ProductControllerAdvice {

    @ExceptionHandler(InvalidPriceException::class)
    fun handleInvalidPriceException(exception: InvalidPriceException): ResponseEntity<ResponseDto<Map<String, Any>>> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ResponseDto(
                    code = exception.errorCode.getCode(),
                    message = exception.errorCode.getMessage(),
                    result = exception.result
                )
            )
    }

    @ExceptionHandler(NotExistsProductException::class)
    fun handleErrorException(exception: NotExistsProductException): ResponseEntity<ResponseDto<Map<String, Any>>> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(
                ResponseDto(
                    code = exception.errorCode.getCode(),
                    message = exception.errorCode.getMessage(),
                    result = exception.result
                )
            )
    }
}