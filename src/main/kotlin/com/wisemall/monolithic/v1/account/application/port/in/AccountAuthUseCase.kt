package com.wisemall.monolithic.v1.account.application.port.`in`

import com.wisemall.monolithic.v1.account.application.port.`in`.command.JoinCommand
import com.wisemall.monolithic.v1.account.application.port.`in`.command.LoginCommand
import com.wisemall.monolithic.v1.account.application.port.`in`.command.LogoutCommand
import com.wisemall.monolithic.v1.account.application.port.`in`.command.ReissueCommand
import com.wisemall.monolithic.v1.account.application.vo.TokenVo

interface AccountAuthUseCase {

    fun join(command: JoinCommand)

    fun login(command: LoginCommand) : TokenVo

    fun logout(command: LogoutCommand)

    fun reissue(command: ReissueCommand) : TokenVo
}