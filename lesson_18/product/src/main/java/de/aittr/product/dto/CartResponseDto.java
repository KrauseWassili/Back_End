package de.aittr.product.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CartResponseDto {
    private Long id;
    private Long customerId;
    private String customerName;
    private List<ProductResponseDto> products;
}
