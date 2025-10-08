package de.aittr.product.service;

import de.aittr.product.dto.ProductRequestDto;
import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.exception.ProductCreateException;
import de.aittr.product.mapper.ProductMapper;
import de.aittr.product.model.Product;
import de.aittr.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.data.domain.Sort;
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
    public List<ProductResponseDto> getAllProductsOrderedById() {
        List<Product> list = repository.findAll(Sort.by("id"));
        return mapper.toDto(list);
    }

    @Override
    public List<ProductResponseDto> getAllProductsOrderedByTitle() {
        List<Product> list = repository.findAll(Sort.by("Title"));
        return mapper.toDto(list);
    }

    @Override
    public List<ProductResponseDto> getAllProductsOrderedByPrice() {
        List<Product> list = repository.findAll(Sort.by("Price"));
        return mapper.toDto(list);
    }

    @Override
    public List<ProductResponseDto> getAllProductsOrderedByActive() {
        List<Product> list = repository.findAll(Sort.by("Active"));
        return mapper.toDto(list);
    }

    @Override
    public List<ProductResponseDto> getActiveProducts() {
        return mapper.toDto(repository.findAllByActive(true));
    }

    @Override
    public ProductResponseDto getById(long id) {
        return mapper.toDto(repository.findById(id));
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
