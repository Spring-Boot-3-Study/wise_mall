package com.wise.mall.payment.persistence

import com.wise.mall.payment.exception.NotExistsPaymentEntityException
import com.wise.mall.payment.feign.OrderFeignClient
import com.wise.mall.payment.model.Payment
import com.wise.mall.payment.model.PaymentStatus
import com.wise.mall.payment.persistence.entity.PaymentEntity
import com.wise.mall.payment.persistence.repository.PaymentRepository
import com.wise.mall.payment.port.out.PaymentPersistencePort
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Component
class PaymentPersistenceAdapter (
    private val paymentRepository : PaymentRepository,
    private val orderFeignClient: OrderFeignClient
): PaymentPersistencePort {

    @Transactional
    override fun createPayment(payment: Payment) {
        paymentRepository.save(PaymentEntity(
            paymentCode = payment.paymentCode,
            price = payment.price,
            orderId = payment.orderId,
            method = payment.method,
            accountId = payment.accountId,
            status = payment.status,
            createdAt = payment.createdAt,
        ))
    }

    @Transactional
    override fun updatePayment(paymentId : Long, paymentStatus: PaymentStatus, tid: String) {
        val payment = paymentRepository.findById(paymentId)
            .orElseThrow { NotExistsPaymentEntityException(paymentId) }

        payment.status = paymentStatus
        payment.tid = tid
        if(payment.status == PaymentStatus.SUCCESS){
            payment.approvedAt = LocalDateTime.now()
        }
        paymentRepository.save(payment)

        orderFeignClient.changeOrderStatus(payment.orderId, payment.status.toString())

    }
}