package de.aittr.product.service;

import de.aittr.product.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
    List<ProductResponseDto> getActiveProducts();
}
