package com.wisemall.monolithic.v1.account.application.port.out

import com.wisemall.monolithic.v1.account.application.domain.model.Account

interface AccountReadPort {

    fun getAccountByEmail(email: String) : Account?

    fun getAccountByRefreshToken(refreshToken: String) : Account?
}