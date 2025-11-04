package com.wise.mall.v1.account.application.port.`in`

import com.wise.mall.v1.account.application.port.`in`.command.JoinCommand
import com.wise.mall.v1.account.application.port.`in`.command.LoginCommand
import com.wise.mall.v1.account.application.port.`in`.command.LogoutCommand
import com.wise.mall.v1.account.application.port.`in`.command.ReissueCommand
import com.wise.mall.v1.account.application.vo.TokenVo

interface AccountAuthUseCase {

    fun join(command: JoinCommand)

    fun login(command: LoginCommand) : TokenVo

    fun logout(command: LogoutCommand)

    fun reissue(command: ReissueCommand) : TokenVo
}