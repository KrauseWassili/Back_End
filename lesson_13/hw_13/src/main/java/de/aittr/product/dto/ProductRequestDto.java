package de.aittr.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ProductRequestDto {
    private  String title;
    private BigDecimal price;
    private boolean active;
}
