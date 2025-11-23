package com.wisemall.monolithic.v1.account.adapter.out.persistence.repository

import com.wisemall.monolithic.v1.account.adapter.out.persistence.entity.BlackAccessTokenEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BlackAccessTokenRepository : JpaRepository<BlackAccessTokenEntity, Long> {
}