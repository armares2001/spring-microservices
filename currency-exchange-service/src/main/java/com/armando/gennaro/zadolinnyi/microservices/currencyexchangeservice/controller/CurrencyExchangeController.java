package com.armando.gennaro.zadolinnyi.microservices.currencyexchangeservice.controller;

import com.armando.gennaro.zadolinnyi.microservices.currencyexchangeservice.entity.ExchangeValue;
import com.armando.gennaro.zadolinnyi.microservices.currencyexchangeservice.jpa.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/")
public class CurrencyExchangeController {

    @Autowired
    private Environment env;

    @Autowired
    private ExchangeValueRepository repository;


    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<?> retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue = repository.findByFromAndTo(from,to);
        if (exchangeValue == null) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(exchangeValue, HttpStatus.OK);
    }
}
