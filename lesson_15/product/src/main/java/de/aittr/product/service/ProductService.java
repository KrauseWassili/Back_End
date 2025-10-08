package de.aittr.product.service;

import de.aittr.product.dto.ProductRequestDto;
import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
    List<ProductResponseDto> getActiveProducts();

    ProductResponseDto addProduct(ProductRequestDto dto);

}
