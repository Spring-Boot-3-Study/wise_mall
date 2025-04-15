package com.wise.mall.account.application.port.out

import com.wise.mall.account.application.domain.model.Account
import com.wise.mall.account.application.vo.CreateAccountVo

interface AccountPersistPort {

    fun createAccount(createAccountVo: CreateAccountVo)

    fun updateAccount(account: Account)
}