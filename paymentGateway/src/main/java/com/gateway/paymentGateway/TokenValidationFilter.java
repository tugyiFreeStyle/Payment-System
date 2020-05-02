package com.gateway.paymentGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class TokenValidationFilter implements GlobalFilter {

    final Logger logger =
            LoggerFactory.getLogger(TokenValidationFilter.class);

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        List<String> headers = exchange.getRequest().getHeaders().get("Authorization");

        logger.info("jwt validation authentication");

        //downstream before

        Mono<Void> result = chain.filter(exchange);

        //dowsntream response

        return result;
    }


}