package com.wise.mall.account.port.out

import java.time.LocalDateTime

interface BlackAccessTokenPersistPort {

    fun createBlackAccessToken(accountId: Long, accessToken: String, expiredAt: LocalDateTime)
}