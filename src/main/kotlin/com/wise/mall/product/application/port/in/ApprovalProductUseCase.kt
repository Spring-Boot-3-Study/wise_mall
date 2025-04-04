package com.wise.mall.product.application.port.`in`

import com.wise.mall.product.application.port.`in`.command.ApprovalAllowProductCommand
import com.wise.mall.product.application.port.`in`.command.ApprovalDenyProductCommand
import com.wise.mall.product.application.port.`in`.command.ApprovalRequestProductCommand

interface ApprovalProductUseCase {

    fun approvalAllowProduct(command: ApprovalAllowProductCommand)

    fun approvalDenyProduct(command: ApprovalDenyProductCommand)

    fun approvalRequestProduct(command: ApprovalRequestProductCommand)
}