package com.wise.mall.account.application.port.`in`.command

data class JoinCommand(

    val name: String,

    val email: String,

    val password: String,
)