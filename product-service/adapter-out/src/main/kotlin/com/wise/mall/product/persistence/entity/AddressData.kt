package com.wise.mall.product.persistence.entity

import jakarta.persistence.Embeddable


@Embeddable
data class AddressData(
    val name: String,
    val phoneNumber: String,
    val postalCode: String,
    val address1: String,
    val address2: String,
) {
}