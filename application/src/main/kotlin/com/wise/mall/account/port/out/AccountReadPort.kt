package com.wise.mall.account.port.out

import com.wise.mall.account.model.Account


interface AccountReadPort {

    fun getAccountByEmail(email: String) : Account?

    fun getAccountByRefreshToken(refreshToken: String) : Account?
}