package com.wise.mall.account.application.port.out

import com.wise.mall.account.application.domain.model.Account

interface AccountReadPort {

    fun getAccountByEmail(email: String) : Account?

    fun getAccountByRefreshToken(refreshToken: String) : Account?
}