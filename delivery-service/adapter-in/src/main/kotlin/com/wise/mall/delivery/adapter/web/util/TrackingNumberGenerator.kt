package com.wise.mall.delivery.adapter.web.util

import java.util.Random

object TrackingNumberGenerator {
    private val random = Random()

    fun generate(): String {
        return buildString {
            repeat(4) { index ->
                if (index > 0) append("-")
                repeat(4) {
                    append(random.nextInt(10))
                }
            }
        }
    }
} 