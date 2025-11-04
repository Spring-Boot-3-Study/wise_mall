package com.wise.mall.v1.account.adapter.`in`.web.exception

import com.wise.mall.v1.account.adapter.`in`.web.AccountController
import com.wise.mall.v1.global.exception.ErrorException
import com.wise.mall.v1.global.response.ResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * 전역 예외 처리 핸들러
 */
@ControllerAdvice(basePackageClasses = [ AccountController::class ])
class AccountExceptionHandler {

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