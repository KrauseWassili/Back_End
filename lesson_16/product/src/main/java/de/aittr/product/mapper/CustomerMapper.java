package de.aittr.product.mapper;

import de.aittr.product.dto.CustomerRequestDto;
import de.aittr.product.dto.CustomerResponseDto;
import de.aittr.product.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    public CustomerResponseDto toDto(Customer customer);
    public List<CustomerResponseDto> toDto(List<Customer> customers);
    Customer fromDto(CustomerRequestDto customerRequestDto);
}
