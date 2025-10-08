package de.aittr.product.controller;

import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
