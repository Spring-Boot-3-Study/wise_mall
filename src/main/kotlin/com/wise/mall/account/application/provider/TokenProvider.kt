package com.wise.mall.account.application.provider

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.security.SignatureException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*

@Component
class TokenProvider (

    @Value("\${jwt.secret}")
    val jwtSecret: String,

    @Value("\${jwt.expiration.accessToken}")
    val accessTokeNExpiration: Long,

    @Value("\${jwt.expiration.refreshToken}")
    val refreshTokeNExpiration: Long,
) {

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

    fun generateAccessToken(accountId: Long, name: String, email: String) : String {

        val claims = Jwts.claims()
        claims["accountId"] = accountId
        claims["nane"] = name
        claims["email"] = email

        return this.generateToken(claims, accessTokeNExpiration)
    }

    fun generateRefreshToken() : String {
        val claims = Jwts.claims()
        return this.generateToken(claims, refreshTokeNExpiration);
    }

    fun generateToken(claims: Claims?, expired: Long): String {
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

    fun extractAllClaims(token: String) : Claims {
        val signingKey: Key = this.getSigningKey()
        return Jwts.parserBuilder()
            .setSigningKey(signingKey)
            .build()
            .parseClaimsJws(token)
            .getBody()
    }

    fun getSigningKey() : Key {
        val keyBytes = jwtSecret.toByteArray(Charsets.UTF_8)
        return Keys.hmacShaKeyFor(keyBytes)
    }
}