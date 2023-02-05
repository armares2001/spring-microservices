package com.armando.gennaro.zadolinnyi.currencyconversionservice.controller;

import com.armando.gennaro.zadolinnyi.currencyconversionservice.entity.CurrencyConversion;
import com.armando.gennaro.zadolinnyi.currencyconversionservice.feignClient.CurrencyExchangeServiceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class CurrencyConversionController {

    @Autowired
    private RestTemplate template;

    @Autowired
    private CurrencyExchangeServiceProxy proxy;


    @GetMapping("currency-converter/from/{from}/to/{to}/quantity/{q}")
    public ResponseEntity<?> convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal q){
        Map<String, String> map=new HashMap<>();
        map.put("from",from);
        map.put("to",to);
        ResponseEntity<CurrencyConversion> resp=template.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,map);

        CurrencyConversion conversion=resp.getBody();
        if (conversion == null) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
        conversion.setQuantity(q);
        conversion.setTotalCalculatedAmount(q.multiply(conversion.getConversionMultiple()));
        return new ResponseEntity<>(conversion, HttpStatus.OK);
    }

    @GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{q}")
    public ResponseEntity<?> convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal q){
        CurrencyConversion conversion=proxy.retrieveExchangeValue(from, to);
        if (conversion == null) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
        conversion.setQuantity(q);
        conversion.setTotalCalculatedAmount(q.multiply(conversion.getConversionMultiple()));

        log.info("{}",conversion);
        return new ResponseEntity<>(conversion, HttpStatus.OK);
    }
}
