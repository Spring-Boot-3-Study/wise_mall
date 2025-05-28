package com.wise.mall.servicegateway.filter

import com.wise.mall.servicegateway.config.FilterConfig
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component

@Component
class AuthorizationFilter : AbstractGatewayFilterFactory<FilterConfig>(
    FilterConfig::class.java,
) {

    override fun apply(config: FilterConfig?): GatewayFilter {
        return GatewayFilter(
            function = { exchange, chain ->
                val request = exchange.request

                val accessToken = request.headers["Authorization"]?.firstOrNull()

                if (config?.preLogger == true) {
                    println("[${request.method}] ${request.uri} => accessToken: $accessToken")
                }

                // TODO: 인증/인가 로직 추가

                chain.filter(exchange)
            }
        )
    }
}