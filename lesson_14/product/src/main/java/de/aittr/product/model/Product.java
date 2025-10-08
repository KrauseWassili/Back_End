package de.aittr.product.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Product {
    private Long id;
    private String title;
    private BigDecimal price;
    private  boolean active;
}
