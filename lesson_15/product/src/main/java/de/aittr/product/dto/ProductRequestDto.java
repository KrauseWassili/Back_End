package de.aittr.product.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductRequestDto {
    private String title;
    private BigDecimal price;
    private  boolean active;
}
