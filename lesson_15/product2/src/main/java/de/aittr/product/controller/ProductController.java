package de.aittr.product.controller;

import de.aittr.product.dto.ProductRequestDto;
import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.exception.ProductCreateException;
import de.aittr.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService service;

    @GetMapping("/products")
    public ResponseEntity< List<ProductResponseDto> > getAll(){
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/products/active")
    public ResponseEntity< List<ProductResponseDto> > getActive(){
        return ResponseEntity.ok(service.getActiveProducts());
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductRequestDto dto){
        try {
            ProductResponseDto productResponseDto = service.addProduct(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto);
        } catch (ProductCreateException e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
