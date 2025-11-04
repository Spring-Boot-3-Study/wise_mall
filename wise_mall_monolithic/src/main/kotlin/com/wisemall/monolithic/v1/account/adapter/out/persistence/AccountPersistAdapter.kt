package com.wisemall.monolithic.v1.account.adapter.out.persistence

import com.wisemall.monolithic.v1.account.adapter.out.persistence.entity.AccountEntity
import com.wisemall.monolithic.v1.account.adapter.out.persistence.exception.NotExistsAccountException
import com.wisemall.monolithic.v1.account.adapter.out.persistence.repository.AccountRepository
import com.wisemall.monolithic.v1.account.application.domain.model.Account
import com.wisemall.monolithic.v1.account.application.port.out.AccountPersistPort
import com.wisemall.monolithic.v1.account.application.vo.CreateAccountVo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class AccountPersistAdapter(
    private val accountRepository: AccountRepository,
) : AccountPersistPort {

    @Transactional
    override fun createAccount(createAccountVo: CreateAccountVo) {
        accountRepository.save(
            AccountEntity(
                name = createAccountVo.name,
                email = createAccountVo.email,
                password = createAccountVo.password,
            )
        )
    }

    @Transactional
    override fun updateAccount(account: Account) {

        val accountEntity = accountRepository.findByIdOrNull(account.accountId)
            ?: throw NotExistsAccountException()

        accountEntity.update(
            name = account.name,
            email = account.email,
            password = account.password,
            refreshToken = account.refreshToken
        )
    }
}