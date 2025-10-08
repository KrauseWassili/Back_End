package de.aittr.product.service;

import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.mapper.ProductMapper;
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
}
