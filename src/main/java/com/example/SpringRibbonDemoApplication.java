package com.example;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// 启用Eure Client服务发现功能，跟@EnableDiscoveryClient一样
@EnableEurekaClient
// 启用短路器功能，来防止死耗
@EnableCircuitBreaker
public class SpringRibbonDemoApplication {
	private static final Logger log = Logger.getLogger(SpringRibbonDemoApplication.class);

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		log.info("初始化负载器！");
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRibbonDemoApplication.class, args);
	}
}
