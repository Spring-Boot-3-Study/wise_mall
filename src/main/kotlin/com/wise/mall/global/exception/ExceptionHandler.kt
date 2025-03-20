package com.wise.mall.global.exception

import com.wise.mall.global.response.ResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * 전역 예외 처리 핸들러
 */
@ControllerAdvice
class ExceptionHandler {

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