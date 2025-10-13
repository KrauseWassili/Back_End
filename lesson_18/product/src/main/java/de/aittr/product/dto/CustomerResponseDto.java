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
public class CustomerResponseDto {
    private Long id;
    private String name;
    private List<AddressResponseDto> addresses;
    private CartResponseDto cartResponseDto;
}
