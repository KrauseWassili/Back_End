package de.aittr.product.mapper;

import de.aittr.product.dto.ProductRequestDto;
import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseDto toResponseDto(Product product);
    List<ProductResponseDto> toResponseDto(List<Product> productList);

    ProductRequestDto fromRequestDto(Product product);
}
