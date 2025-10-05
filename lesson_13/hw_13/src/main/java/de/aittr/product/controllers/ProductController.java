package de.aittr.product.controllers;

import de.aittr.product.dto.ProductRequestDto;
import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.mapper.ProductMapper;
import de.aittr.product.model.Product;
import de.aittr.product.repository.ProductRepository;
import de.aittr.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class ProductController {

    private final ProductMapper mapper;
    private final ProductService service;


    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDto>> getProducts(
            @RequestParam (defaultValue = "") String status
    ) {
       List<ProductResponseDto> result = service.getAllProducts();

        if(status.equalsIgnoreCase("active"))
            result = result.stream()
                    .filter(ProductResponseDto::isActive)
                    .toList();

        else if (status.equalsIgnoreCase("inactive")) {
            result = result.stream()
                    .filter(p -> !p.isActive())
                    .toList();
        }

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProduct(@PathVariable(name = "id") long productId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getProductById(productId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID "+ productId + " не найден");       }

    }



    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequestDto product) {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.addProduct(product));
    }

    @PutMapping("/products")
    public ResponseEntity<?> setActive(
            @RequestParam(name= "id") long productId,
            @RequestParam(name= "active") boolean active
            ){
        service.setActiveById(productId,active);
        return ResponseEntity.status(HttpStatus.OK).body(service.getProductById(productId));
    }

}
