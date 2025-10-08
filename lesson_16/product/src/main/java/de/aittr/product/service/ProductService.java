package de.aittr.product.service;

import de.aittr.product.dto.ProductRequestDto;
import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
    List<ProductResponseDto> getAllProductsOrderedById();
    List<ProductResponseDto> getAllProductsOrderedByTitle();
    List<ProductResponseDto> getAllProductsOrderedByPrice();
    List<ProductResponseDto> getAllProductsOrderedByActive();
    List<ProductResponseDto> getActiveProducts();
    ProductResponseDto getById(long id);

    ProductResponseDto addProduct(ProductRequestDto dto);

}
