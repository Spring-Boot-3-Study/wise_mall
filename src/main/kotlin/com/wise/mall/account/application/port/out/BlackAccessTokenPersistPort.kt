package com.wise.mall.account.application.port.out

import java.time.LocalDateTime

interface BlackAccessTokenPersistPort {

    fun createBlackAccessToken(accountId: Long, accessToken: String, expiredAt: LocalDateTime)
}