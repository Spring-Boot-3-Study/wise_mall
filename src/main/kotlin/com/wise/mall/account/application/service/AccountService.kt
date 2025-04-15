package com.wise.mall.account.application.service

import com.wise.mall.account.application.exception.AlreadyExistsEmailException
import com.wise.mall.account.application.exception.NotMatchAccountException
import com.wise.mall.account.application.exception.TokenExpiredException
import com.wise.mall.account.application.port.`in`.AccountAuthUseCase
import com.wise.mall.account.application.port.`in`.command.JoinCommand
import com.wise.mall.account.application.port.`in`.command.LoginCommand
import com.wise.mall.account.application.port.`in`.command.LogoutCommand
import com.wise.mall.account.application.port.`in`.command.ReissueCommand
import com.wise.mall.account.application.port.out.AccountPersistPort
import com.wise.mall.account.application.port.out.AccountReadPort
import com.wise.mall.account.application.port.out.BlackAccessTokenPersistPort
import com.wise.mall.account.application.provider.TokenProvider
import com.wise.mall.account.application.vo.CreateAccountVo
import com.wise.mall.account.application.vo.TokenVo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class AccountService(
    private val accountPersistPort: AccountPersistPort,
    private val accountReadPort: AccountReadPort,
    private val blackAccessTokenPersistPort: BlackAccessTokenPersistPort,
    private val tokenProvider: TokenProvider,
) : AccountAuthUseCase {

    /**
     * 회원 가입
     */
    @Transactional
    override fun join(command: JoinCommand) {

        // 이메일 중복 여부 체크
        accountReadPort.getAccountByEmail(email = command.email)?.let {
            throw AlreadyExistsEmailException(email = command.email)
        }

        val createAccountVo = CreateAccountVo(
            name = command.name,
            email = command.email,
            password = command.password,
        )

        // 새로운 회원 생성
        accountPersistPort.createAccount(createAccountVo = createAccountVo);
    }

    /**
     * 로그인
     */
    @Transactional
    override fun login(command: LoginCommand) : TokenVo {

        val account = accountReadPort.getAccountByEmail(email = command.email)
            ?: throw NotMatchAccountException()

        if (account.password != command.password) {
            throw NotMatchAccountException()
        }

        val refreshToken = tokenProvider.generateRefreshToken()
        val accessToken = tokenProvider.generateAccessToken(accountId = account.accountId, name = account.name, email = account.email)

        account.login(refreshToken = refreshToken)

        accountPersistPort.updateAccount(account = account)

        return TokenVo(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }

    /**
     * 로그 아웃
     */
    @Transactional
    override fun logout(command: LogoutCommand) {

        val account = accountReadPort.getAccountByRefreshToken(refreshToken = command.refreshToken)
            ?: throw NotMatchAccountException()

        // 로그 아웃 (리프래시 토큰 삭제)
        account.logout()

        val expiredAt = tokenProvider.getExpiredAt(token = command.accessToken)

        // 엑세스 토큰이 만료되지 않은 경우 블랙 리스트 등록
        if (expiredAt.isAfter(LocalDateTime.now())) {
            blackAccessTokenPersistPort.createBlackAccessToken(
                accountId = account.accountId,
                accessToken = command.accessToken,
                expiredAt = expiredAt
            )
        }

        // 회원 정보 수정
        accountPersistPort.updateAccount(account = account)
    }

    /**
     * 토큰 재발행
     */
    @Transactional
    override fun reissue(command: ReissueCommand) : TokenVo  {

        // 만료 여부 체크
        if (tokenProvider.isExpired(token = command.refreshToken)) {
            throw TokenExpiredException(token = command.refreshToken)
        }

        // 리프래시 토큰 기준 회원 조회
        val account = accountReadPort.getAccountByRefreshToken(refreshToken = command.refreshToken)
            ?: throw NotMatchAccountException()

        // 토큰 재발행
        val refreshToken = tokenProvider.generateRefreshToken()
        val accessToken = tokenProvider.generateAccessToken(accountId = account.accountId, name = account.name, email = account.email)

        account.reissue(refreshToken = refreshToken)

        accountPersistPort.updateAccount(account = account)

        return TokenVo(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }
}