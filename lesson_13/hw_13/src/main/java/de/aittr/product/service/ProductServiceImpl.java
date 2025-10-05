package de.aittr.product.service;

import de.aittr.product.dto.ProductRequestDto;
import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.mapper.ProductMapper;
import de.aittr.product.model.Product;
import de.aittr.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
private final ProductRepository repository;
private final ProductMapper mapper;


    @Override
    public List<ProductResponseDto> getAllProducts() {
        return mapper.toResponseDto(repository.findAll());
    }

    @Override
    public ProductResponseDto getProductById(long id) {
        return mapper.toResponseDto(repository.findById(id));
    }

    @Override

    public int addProduct(ProductRequestDto productRequestDto) {
        return repository.add(productRequestDto.getTitle(),productRequestDto.getPrice(), productRequestDto.isActive());
    }

    @Override
    public int setActiveById(long id, boolean active) {
        return repository.setActiveById(id,active);
    }
}
