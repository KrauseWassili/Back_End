package de.aittr.product.service;

import de.aittr.product.dto.CustomerRequestDto;
import de.aittr.product.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDto> getAll();
    CustomerResponseDto getById(long id);

    CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto);
    CustomerResponseDto setActiveById(long id,boolean status);

}
