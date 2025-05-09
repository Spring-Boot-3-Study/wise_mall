package com.wise.mall.account.persistence.repository

import com.wise.mall.account.persistence.entity.BlackAccessTokenEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BlackAccessTokenRepository : JpaRepository<BlackAccessTokenEntity, Long> {
}