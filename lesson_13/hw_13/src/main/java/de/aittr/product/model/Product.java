package de.aittr.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@ToString
public class Product {
    private Long id;
    private  String title;
    private BigDecimal price;
    private boolean active;

}
