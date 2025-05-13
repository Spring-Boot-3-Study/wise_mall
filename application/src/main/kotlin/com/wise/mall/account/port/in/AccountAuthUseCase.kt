package com.wise.mall.account.port.`in`

import com.wise.mall.account.port.`in`.command.JoinCommand
import com.wise.mall.account.port.`in`.command.LoginCommand
import com.wise.mall.account.port.`in`.command.LogoutCommand
import com.wise.mall.account.port.`in`.command.ReissueCommand
import com.wise.mall.account.vo.TokenVo

interface AccountAuthUseCase {

    fun join(command: JoinCommand)

    fun login(command: LoginCommand) : TokenVo

    fun logout(command: LogoutCommand)

    fun reissue(command: ReissueCommand) : TokenVo
}