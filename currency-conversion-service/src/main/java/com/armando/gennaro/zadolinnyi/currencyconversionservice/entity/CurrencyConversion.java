package com.armando.gennaro.zadolinnyi.currencyconversionservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.*;

/*import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;*/
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrencyConversion {
    @Id
    private Long id;

    @Column(name="exchange_from")
    private String from;

    @Column(name="exchange_to")
    private String to;

    private BigDecimal conversionMultiple;

    private BigDecimal quantity;

    private BigDecimal totalCalculatedAmount;

    private int port;
}
