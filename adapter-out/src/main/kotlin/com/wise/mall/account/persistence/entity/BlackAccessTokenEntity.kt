package com.wise.mall.account.persistence.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "black_access_token")
class BlackAccessTokenEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val blackAccessTokenId: Long? = null,

    @Column(name = "account_id")
    val accountId: Long,

    @Column(name = "access_token")
    val accessToken: String,

    @Column(name = "expired_at")
    val expiredAt: LocalDateTime,

) {}
