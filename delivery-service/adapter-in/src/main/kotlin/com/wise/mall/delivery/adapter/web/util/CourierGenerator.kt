package com.wise.mall.delivery.adapter.web.util

import java.util.Random

object CourierGenerator {
    private val random = Random()
    
    private val couriers = listOf(
        "CJ대한통운",
        "로젠택배",
        "우체국택배",
        "롯데택배",
        "한진택배",
        "우체국택배",
        "로젠택배",
        "롯데택배",
        "한진택배",
        "우체국택배"
    )

    fun generate(): String {
        return couriers[random.nextInt(couriers.size)]
    }
} 