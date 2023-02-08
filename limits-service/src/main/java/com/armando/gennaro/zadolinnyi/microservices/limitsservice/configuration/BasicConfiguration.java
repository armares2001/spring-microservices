package com.armando.gennaro.zadolinnyi.microservices.limitsservice.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicConfiguration {
    private int min;
    private int max;
}
