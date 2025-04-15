package com.wise.mall.account.application.port.`in`.command

data class LogoutCommand(

    val accessToken: String,

    val refreshToken: String,
)
