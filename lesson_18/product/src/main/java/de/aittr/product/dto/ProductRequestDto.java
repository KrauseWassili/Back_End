package de.aittr.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductRequestDto {
    @NotBlank
    private String title;
    private BigDecimal price;
    private  boolean active;
}
