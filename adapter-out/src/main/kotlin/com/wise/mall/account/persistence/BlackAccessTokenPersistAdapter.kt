package com.wise.mall.account.persistence

import com.wise.mall.account.persistence.entity.BlackAccessTokenEntity
import com.wise.mall.account.persistence.repository.BlackAccessTokenRepository
import com.wise.mall.account.application.port.out.BlackAccessTokenPersistPort
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class BlackAccessTokenPersistAdapter(
    private val blackAccessTokenRepository: BlackAccessTokenRepository,
) : BlackAccessTokenPersistPort {

    /**
     * 엑세스 토큰 강제 만료 정보 등록
     */
    override fun createBlackAccessToken(accountId: Long, accessToken: String, expiredAt: LocalDateTime) {
        blackAccessTokenRepository.save(
            BlackAccessTokenEntity(
                accountId = accountId,
                accessToken = accessToken,
                expiredAt = expiredAt,
            )
        )
    }
}