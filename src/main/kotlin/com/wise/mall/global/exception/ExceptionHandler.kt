package com.wise.mall.global.exception

import com.wise.mall.global.response.ResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(AdapterException::class)
    fun handleAdapterException(adapterException: AdapterException): ResponseEntity<ResponseDto<Map<String, Any>>> {
        return ResponseEntity
            .status(adapterException.response.getStatus())
            .body(adapterException.response.toResponseDto(adapterException.result))
    }
}