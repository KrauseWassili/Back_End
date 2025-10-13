package de.aittr.product.mapper;

import de.aittr.product.dto.AddressRequestDto;
import de.aittr.product.dto.AddressResponseDto;
import de.aittr.product.model.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressResponseDto toDto(Address address);
    List<AddressResponseDto> toDto(List<Address> address);

    Address fromDto(AddressRequestDto dto);

}
