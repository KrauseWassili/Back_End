package de.aittr.product.mapper;

import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    public ProductResponseDto toDto(Product product);
    public List<ProductResponseDto> toDto(List<Product> products);

}
