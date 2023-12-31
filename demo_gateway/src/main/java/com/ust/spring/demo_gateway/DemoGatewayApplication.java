package com.ust.spring.demo_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoGatewayApplication {

    @Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder){
		return builder.routes()
		.route(p -> p 
		.path("/get")
		.filters(f->f.addRequestHeader("Hello","World"))
		.uri("http://httpbin.org:80"))
		.build();
		
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoGatewayApplication.class, args);
		System.out.println("hello world");
	}

}
