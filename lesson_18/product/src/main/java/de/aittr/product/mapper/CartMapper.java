package de.aittr.product.mapper;

import de.aittr.product.dto.CartResponseDto;
import de.aittr.product.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {ProductMapper.class})
// uses - определяет, что для маппинга другой сущности (Product) уже ест готовы маппер
public interface CartMapper {

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "customerName", source = "customer.name")
    CartResponseDto toDto(Cart cart);
    List<CartResponseDto> toDto(List<Cart> cart);

}
