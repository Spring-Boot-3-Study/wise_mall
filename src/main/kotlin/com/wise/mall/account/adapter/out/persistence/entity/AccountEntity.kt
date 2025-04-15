package com.wise.mall.account.adapter.out.persistence.entity

import com.wise.mall.global.entity.BaseTimeEntity
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name = "account")
@EntityListeners(AuditingEntityListener::class)
class AccountEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "refresh_token")
    var refreshToken: String? = null,

) : BaseTimeEntity() {

    fun update(name: String, email: String, password: String, refreshToken: String?) {
        this.name = name
        this.email = email
        this.password = password
        this.refreshToken = refreshToken
    }
}
