package com.armando.gennaro.zadolinnyi.currencyconversionservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.client.RestTemplate;



@Configuration
public class TemplateConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

/*    <parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.0.1</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>*/
}
