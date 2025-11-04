package com.wise.mall.v1.account.application.port.out

import java.time.LocalDateTime

interface BlackAccessTokenPersistPort {

    fun createBlackAccessToken(accountId: Long, accessToken: String, expiredAt: LocalDateTime)
}