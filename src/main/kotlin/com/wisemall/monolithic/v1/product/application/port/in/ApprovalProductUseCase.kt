package com.wisemall.monolithic.v1.product.application.port.`in`

import com.wisemall.monolithic.v1.product.application.port.`in`.command.ApprovalAllowProductCommand
import com.wisemall.monolithic.v1.product.application.port.`in`.command.ApprovalDenyProductCommand
import com.wisemall.monolithic.v1.product.application.port.`in`.command.ApprovalRequestProductCommand

interface ApprovalProductUseCase {

    fun approvalAllowProduct(command: ApprovalAllowProductCommand)

    fun approvalDenyProduct(command: ApprovalDenyProductCommand)

    fun approvalRequestProduct(command: ApprovalRequestProductCommand)
}