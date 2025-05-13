package com.wise.mall.payment.persistence.repository

import com.wise.mall.payment.persistence.entity.PaymentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository :JpaRepository <PaymentEntity,Long>{
    fun findAllByAccountId(accountId: Long): List<PaymentEntity>
}