package com.wise.mall.product.web.exception

import com.wise.mall.common.exception.ErrorException
import com.wise.mall.common.response.ResponseDto
import com.wise.mall.product.web.ProductController
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

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(errorException: RuntimeException): ResponseEntity<ResponseDto<Map<String, Any>>> {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ResponseDto(
                    code = 0,
                    message =  errorException.message.toString(),
                    result = mapOf(),
                )
            )
    }
}