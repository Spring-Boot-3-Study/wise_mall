package com.wise.mall.v1.account.application.port.`in`.command

data class LogoutCommand(

    val accessToken: String,

    val refreshToken: String,
)
