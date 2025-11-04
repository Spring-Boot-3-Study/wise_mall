package com.wisemall.monolithic.v1.account.application.provider

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.security.SignatureException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.Key
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Component
class TokenProvider (

    @param:Value("\${jwt.secret}")
    val jwtSecret: String,

    @param:Value("\${jwt.expiration.accessToken}")
    val accessTokeNExpiration: Long,

    @param:Value("\${jwt.expiration.refreshToken}")
    val refreshTokeNExpiration: Long,
) {

    /**
     * 토큰 만료 여부 검증
     */
    fun isExpired(token: String) : Boolean {
        try {
            val expiration: Date = this.extractAllClaims(token).expiration
            return expiration.before(Date())
        } catch (e: ExpiredJwtException) {
            return true
        } catch (e: SignatureException) {
            return true
        } catch (e: IllegalArgumentException) {
            return true
        }
    }

    /**
     * 토큰 만료 시간 조회
     */
    fun getExpiredAt(token: String) : LocalDateTime {
        return try {
            this.extractAllClaims(token).expiration.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
        } catch (e: ExpiredJwtException) {
            LocalDateTime.now()
        } catch (e: SignatureException) {
            LocalDateTime.now()
        } catch (e: IllegalArgumentException) {
            LocalDateTime.now()
        }
    }

    /**
     * 엑세스 토큰 발행
     */
    fun generateAccessToken(accountId: Long, name: String, email: String) : String {

        val claims = Jwts.claims()
        claims["accountId"] = accountId
        claims["nane"] = name
        claims["email"] = email

        return this.generateToken(claims, accessTokeNExpiration)
    }

    /**
     * 리프래시 토큰 발행
     */
    fun generateRefreshToken() : String {
        val claims = Jwts.claims()
        return this.generateToken(claims, refreshTokeNExpiration);
    }

    /**
     * 토큰 생성
     */
    private fun generateToken(claims: Claims?, expired: Long): String {
        val now = System.currentTimeMillis()
        val issuedAt = Date(now)
        val expiration = Date(now + expired * 1000)
        val signingKey: Key = this.getSigningKey()

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(issuedAt)
            .setExpiration(expiration)
            .signWith(signingKey, SignatureAlgorithm.HS256)
            .compact()
    }

    /**
     * 클레임 생성
     */
    private fun extractAllClaims(token: String) : Claims {
        val signingKey: Key = this.getSigningKey()
        return Jwts.parserBuilder()
            .setSigningKey(signingKey)
            .build()
            .parseClaimsJws(token)
            .getBody()
    }

    /**
     * 서명키 생성
     */
    private fun getSigningKey() : Key {
        val keyBytes = jwtSecret.toByteArray(Charsets.UTF_8)
        return Keys.hmacShaKeyFor(keyBytes)
    }
}