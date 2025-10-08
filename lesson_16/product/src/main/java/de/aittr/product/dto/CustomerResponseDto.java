package de.aittr.product.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerResponseDto {
    private Long id;
    private String name;
    private boolean active;
}
