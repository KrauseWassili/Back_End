package de.aittr.product.controller;

import de.aittr.product.dto.ProductRequestDto;
import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.exception.ApiError;
import de.aittr.product.exception.ProductCreateException;
import de.aittr.product.exception.ProductIncorrectEntryException;
import de.aittr.product.exception.ProductNotFoundException;
import de.aittr.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService service;

    //@RequestMapping(path ="/products", method = RequestMethod.GET )
    @GetMapping
    public ResponseEntity< List<ProductResponseDto> > getAll(){
        return ResponseEntity.ok(service.getAllProducts());
    }
    // /api/products/active
    @GetMapping("/active")
    public ResponseEntity< List<ProductResponseDto> > getActive(){
        return ResponseEntity.ok(service.getActiveProducts());
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> addProduct(@Valid @RequestBody ProductRequestDto dto){
            ProductResponseDto productResponseDto = service.addProduct(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiError> productNotFoundHandler(ProductNotFoundException ex){
        ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> incorrectEntryHandler(MethodArgumentNotValidException ex){
        ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

}
