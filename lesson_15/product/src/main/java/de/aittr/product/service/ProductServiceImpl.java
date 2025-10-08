package de.aittr.product.service;

import de.aittr.product.dto.ProductRequestDto;
import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.exception.ProductCreateException;
import de.aittr.product.mapper.ProductMapper;
import de.aittr.product.model.Product;
import de.aittr.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<ProductResponseDto> getActiveProducts() {
        return mapper.toDto(repository.findByActive(true));
    }

    @Override
    public ProductResponseDto addProduct(ProductRequestDto dto) {
        Product product = mapper.fromDto(dto);
        product.setId(null); // !!! можно и не писать т.к. и так id продукта = null
        Product savedProduct = repository.save(product);
        if (savedProduct == null){
            throw new ProductCreateException(product);
        }
        return mapper.toDto(savedProduct);
    }
}
