package com.wise.mall.account.adapter.out.persistence.repository

import com.wise.mall.account.adapter.out.persistence.entity.BlackAccessTokenEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BlackAccessTokenRepository : JpaRepository<BlackAccessTokenEntity, Long> {
}