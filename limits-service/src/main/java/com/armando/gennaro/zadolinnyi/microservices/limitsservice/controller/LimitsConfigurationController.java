package com.armando.gennaro.zadolinnyi.microservices.limitsservice.controller;

import com.armando.gennaro.zadolinnyi.microservices.limitsservice.configuration.BasicConfiguration;
import com.armando.gennaro.zadolinnyi.microservices.limitsservice.model.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LimitsConfigurationController {

    @Autowired
    private BasicConfiguration configuration;

    @GetMapping("limits")
    public LimitConfiguration findAll(){
        return new LimitConfiguration(configuration.getMax(),configuration.getMin());
    }

    @GetMapping("fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    public LimitConfiguration findConfiguration(){
        throw new RuntimeException("not available");
    }

    public LimitConfiguration fallbackRetrieveConfiguration(){
        return new LimitConfiguration(91,84);
    }
}
