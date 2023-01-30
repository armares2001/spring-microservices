package com.armando.gennaro.zadolinnyi.microservices.currencyexchangeservice.jpa;

import com.armando.gennaro.zadolinnyi.microservices.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {

    ExchangeValue findByFromAndTo(String from, String to);

}
