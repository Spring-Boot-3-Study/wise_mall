package com.wise.mall.account.persistence

import com.wise.mall.account.persistence.exception.NotExistsAccountException
import com.wise.mall.account.model.Account
import com.wise.mall.account.persistence.entity.AccountEntity
import com.wise.mall.account.persistence.repository.AccountRepository
import com.wise.mall.account.port.out.AccountPersistPort
import com.wise.mall.account.vo.CreateAccountVo
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