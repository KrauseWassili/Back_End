package de.aittr.product.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerRequestDto {
    private String name;
    private boolean active;
}
