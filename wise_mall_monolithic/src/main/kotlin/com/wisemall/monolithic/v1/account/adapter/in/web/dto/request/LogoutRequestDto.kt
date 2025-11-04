package com.wise.mall.v1.account.adapter.`in`.web.dto.request

data class LogoutRequestDto(

    val accessToken: String,

    val refreshToken: String,
)
