package com.armando.gennaro.zadolinnyi.currencyconversionservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@RibbonClient(name = "server", configuration = RibbonClientConfiguration.class)
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.armando.gennaro.zadolinnyi.currencyconversionservice.feignClient")
/*@EnableEurekaClient*/
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
}
