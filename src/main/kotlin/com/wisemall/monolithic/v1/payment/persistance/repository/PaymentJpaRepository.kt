package com.wisemall.monolithic.v1.payment.persistance.repository

import com.wisemall.monolithic.v1.payment.persistance.entity.PaymentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentJpaRepository: JpaRepository<PaymentEntity, Long> {
    fun findByaccountId(accountId: Long): List<PaymentEntity>
    fun findByOrderId(orderId: Long): PaymentEntity
}