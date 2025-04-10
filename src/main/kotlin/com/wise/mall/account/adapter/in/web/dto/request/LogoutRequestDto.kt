package com.wise.mall.account.adapter.`in`.web.dto.request

data class LogoutRequestDto(

    val accessToken: String,

    val refreshToken: String,
)
