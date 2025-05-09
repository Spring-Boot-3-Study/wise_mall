package com.wise.mall.account.dto.request

data class LogoutRequestDto(

    val accessToken: String,

    val refreshToken: String,
)
