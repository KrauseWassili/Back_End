package de.aittr.product.service;

import de.aittr.product.dto.ProductRequestDto;
import de.aittr.product.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(long id);

    int addProduct(ProductRequestDto product);

    int setActiveById(long id, boolean active);
}
