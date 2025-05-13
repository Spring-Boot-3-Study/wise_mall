package com.wise.mall.account

import com.wise.mall.account.dto.request.JoinRequestDto
import com.wise.mall.account.dto.request.LoginRequestDto
import com.wise.mall.account.dto.request.LogoutRequestDto
import com.wise.mall.account.dto.request.ReissueRequestDto
import com.wise.mall.account.dto.response.LoginResponseDto
import com.wise.mall.account.dto.response.ReissueResponseDto
import com.wise.mall.account.port.`in`.AccountAuthUseCase
import com.wise.mall.account.port.`in`.command.JoinCommand
import com.wise.mall.account.port.`in`.command.LoginCommand
import com.wise.mall.account.port.`in`.command.LogoutCommand
import com.wise.mall.account.port.`in`.command.ReissueCommand
import com.wise.mall.common.response.ResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountController(
    private val accountAuthUseCase: AccountAuthUseCase,
) {

    /**
     * 회원 가입 앤드포인트
     */
    @PostMapping("/join")
    fun join(@RequestBody joinRequestDto: JoinRequestDto): ResponseEntity<ResponseDto<Map<String, Any>>> {

        accountAuthUseCase.join(
            command = JoinCommand(
                name = joinRequestDto.name,
                email = joinRequestDto.email,
                password = joinRequestDto.password
            )
        )

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(AccountAdapterResponse.ACCOUNT_JOIN_SUCCESS.toResponseDto())
    }

    /**
     * 로그인 앤드포인트
     */
    @PostMapping("/login")
    fun login(@RequestBody loginRequestDto: LoginRequestDto): ResponseEntity<ResponseDto<LoginResponseDto>> {

        val tokenVo = accountAuthUseCase.login(
            command = LoginCommand(
                email = loginRequestDto.email,
                password = loginRequestDto.password
            )
        )

        val loginResponseDto = LoginResponseDto(
            accessToken = tokenVo.accessToken,
            refreshToken = tokenVo.refreshToken,
        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(AccountAdapterResponse.ACCOUNT_LOGIN_SUCCESS.toResponseDto(loginResponseDto))
    }

    /**
     * 로그아웃 앤드포인트
     */
    @PostMapping("/logout")
    fun logout(@RequestBody logoutRequestDto: LogoutRequestDto): ResponseEntity<ResponseDto<Map<String, Any>>> {
        
        println(logoutRequestDto)

        accountAuthUseCase.logout(
            command = LogoutCommand(
                accessToken = logoutRequestDto.accessToken,
                refreshToken = logoutRequestDto.refreshToken,
            )
        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(AccountAdapterResponse.ACCOUNT_LOGOUT_SUCCESS.toResponseDto())
    }

    /**
     * 토큰 재발행 앤드포인트
     */
    @PostMapping("/reissue")
    fun reissue(@RequestBody reissueRequestDto: ReissueRequestDto): ResponseEntity<ResponseDto<ReissueResponseDto>> {

        val tokenVo = accountAuthUseCase.reissue(
            command = ReissueCommand(
                refreshToken = reissueRequestDto.refreshToken,
            )
        )

        val reissueResponseDto = ReissueResponseDto(
            accessToken = tokenVo.accessToken,
            refreshToken = tokenVo.refreshToken,
        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(AccountAdapterResponse.ACCOUNT_REISSUE_SUCCESS.toResponseDto(reissueResponseDto))
    }
}