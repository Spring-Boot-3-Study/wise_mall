package com.wisemall.monolithic.v1.global.vo

import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    val name: String,
    val phoneNumber: String,
    val postalCode: String,
    val address1: String,
    val address2: String,
) {
}