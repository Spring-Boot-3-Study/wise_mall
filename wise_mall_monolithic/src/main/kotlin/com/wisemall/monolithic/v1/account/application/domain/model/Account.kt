package com.wise.mall.v1.account.application.domain.model

import java.time.LocalDateTime

data class Account(

    val accountId: Long,

    val name: String,

    val email: String,

    val password: String,

    val createdAt: LocalDateTime,

    val updatedAt: LocalDateTime,

    var refreshToken: String?,

) {

    fun login(refreshToken: String) {
        this.refreshToken = refreshToken
    }

    fun logout() {
        this.refreshToken = null
    }

    fun reissue(refreshToken: String) {
        this.refreshToken = refreshToken
    }
}
