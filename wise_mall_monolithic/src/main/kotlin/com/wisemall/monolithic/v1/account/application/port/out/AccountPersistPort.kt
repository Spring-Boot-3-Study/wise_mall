package com.wise.mall.v1.account.application.port.out

import com.wise.mall.v1.account.application.domain.model.Account
import com.wise.mall.v1.account.application.vo.CreateAccountVo

interface AccountPersistPort {

    fun createAccount(createAccountVo: CreateAccountVo)

    fun updateAccount(account: Account)
}