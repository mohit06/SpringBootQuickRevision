package com.apigateway.microservices.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * http://localhost:8765/CURRENCY-EXCHANGE-SERVICE/currency-exchange/from/USD/to/INR
 * http://localhost:8765 = API GateWay address, CURRENCY-EXCHANGE-SERVICE = service registered with Eureka, currency-exchange/from/USD/to/INR = endpoint we wanted to trigger
 * This is how default routes can be created.
 * This class is responsible for providing configuration for custom routes.
 */



@Configuration 
class ApiGAteWayConfiguration {

	@Bean
	public RouteLocator gateWayRouter(RouteLocatorBuilder builder) {

		return builder.routes()
				.route(p -> p.path("/get").filters(f->f.addRequestHeader("HeaderComp", "HeaderVal"))
						
				.uri("http://httpbin.org:80")).route(p -> p.path("/currency-exchange/**").uri("lb://CURRENCY-EXCHANGE-SERVICE"))
				.route(p->p.path("/currency-conversion/**").uri("lb://CURRENCY-CONVERSION-SERVICE"))
				.route(p->p.path("/currency-conversion-feign/**").uri("lb://currency-conversion-service"))
				.route(p->p.path("/currency-conversion-new/**").filters(f->f.rewritePath("/currency-conversion-new/?<segment>/*",
						"/currency-conversion-feign/${segment}")).uri("lb://currency-conversion-service"))
				.build();
	
	}
	
	
	
}
