package com.wisemall.monolithic.v1.account.adapter.out.persistence

import com.wisemall.monolithic.v1.account.adapter.out.persistence.repository.AccountRepository
import com.wisemall.monolithic.v1.account.application.domain.model.Account
import com.wisemall.monolithic.v1.account.application.port.out.AccountReadPort
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AccountReadAdapter(
    private val accountRepository: AccountRepository,
) : AccountReadPort {

    @Transactional
    override fun getAccountByEmail(email: String): Account? =
        accountRepository.findByEmail(email = email)?.let { accountEntity ->
                Account(
                    accountId = accountEntity.id!!,
                    name = accountEntity.name,
                    email = accountEntity.email,
                    password = accountEntity.password,
                    refreshToken = accountEntity.refreshToken,
                    createdAt = accountEntity.createdAt!!,
                    updatedAt = accountEntity.updatedAt!!,
                )
            }

    @Transactional
    override fun getAccountByRefreshToken(refreshToken: String): Account? =
        accountRepository.findByRefreshToken(refreshToken = refreshToken)?.let { accountEntity ->
            Account(
                accountId = accountEntity.id!!,
                name = accountEntity.name,
                email = accountEntity.email,
                password = accountEntity.password,
                refreshToken = accountEntity.refreshToken,
                createdAt = accountEntity.createdAt!!,
                updatedAt = accountEntity.updatedAt!!,
            )
        }
}