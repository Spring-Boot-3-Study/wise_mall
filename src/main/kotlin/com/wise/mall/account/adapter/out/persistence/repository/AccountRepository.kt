package com.wise.mall.account.adapter.out.persistence.repository

import com.wise.mall.account.adapter.out.persistence.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<AccountEntity, Long> {

    fun findByEmail(email: String): AccountEntity?

    fun findByRefreshToken(refreshToken: String): AccountEntity?
}