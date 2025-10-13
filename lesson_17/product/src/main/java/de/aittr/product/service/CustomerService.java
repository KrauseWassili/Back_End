package de.aittr.product.service;

import de.aittr.product.dto.CustomerRequestDto;
import de.aittr.product.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto addNew(CustomerRequestDto dto);
}
