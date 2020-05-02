package com.gateway.paymentGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentGatewayApplication.class, args);
	}

	final Logger logger =
			LoggerFactory.getLogger(PaymentGatewayApplication.class);

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {

//circuit breaker implementation.
// euroka integration

		return builder.routes()
				.route(p -> p
						.path("/api/v1/customers/*")
						.and()

						.readBody(String.class, requestBody -> {logger.info(requestBody);

							return true;})
						.uri("http://localhost:8080"))

				.build();

		// 10 service
	}

}
