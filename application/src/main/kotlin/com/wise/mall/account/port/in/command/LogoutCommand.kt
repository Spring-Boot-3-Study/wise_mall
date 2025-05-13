package com.wise.mall.account.port.`in`.command

data class LogoutCommand(

    val accessToken: String,

    val refreshToken: String,
)
