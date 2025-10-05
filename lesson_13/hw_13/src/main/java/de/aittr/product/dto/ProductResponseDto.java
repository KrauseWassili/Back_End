package de.aittr.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ProductResponseDto {
    private Long id;
    private  String title;
    private BigDecimal price;
    private boolean active;
}
