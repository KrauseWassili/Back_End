package de.aittr.product.dto;

import java.util.List;

public class CustomerResponseDto {
    private Long id;
    private String name;
    private List<AddressResponseDto> addresses;
    private CartResponseDto cartResponseDto;
}
