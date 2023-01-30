package com.armando.gennaro.zadolinnyi.microservices.currencyexchangeservice.entity;

import javax.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/*@Getter
@Setter
@ToString*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExchangeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="exchange_from")
    private String from;

    @Column(name="exchange_to")
    private String to;

    private BigDecimal conversionMultiple;

    private int port;
}
