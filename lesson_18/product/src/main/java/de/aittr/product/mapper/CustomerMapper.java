package de.aittr.product.mapper;

import de.aittr.product.dto.CustomerRequestDto;
import de.aittr.product.dto.CustomerResponseDto;
import de.aittr.product.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer fromDto(CustomerRequestDto dto);
    CustomerResponseDto toDto(Customer customer);
    List<CustomerResponseDto> toDto(List<Customer> customer);

}
