package de.aittr.product.controller;

import de.aittr.product.dto.CustomerRequestDto;
import de.aittr.product.dto.CustomerResponseDto;
import de.aittr.product.dto.ProductRequestDto;
import de.aittr.product.dto.ProductResponseDto;
import de.aittr.product.exception.CustomerCreateException;
import de.aittr.product.exception.ProductCreateException;
import de.aittr.product.service.CustomerService;
import de.aittr.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;
    private final CustomerService customerService;

    //@RequestMapping(path ="/products", method = RequestMethod.GET )
    @GetMapping("/products")
    public ResponseEntity< List<ProductResponseDto> > getAll(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    // /api/products/active
    @GetMapping("products/active")
    public ResponseEntity< List<ProductResponseDto> > getActive(){
        return ResponseEntity.ok(productService.getActiveProducts());
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductRequestDto dto){
        try {
            ProductResponseDto productResponseDto = productService.addProduct(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto);
        } catch (ProductCreateException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponseDto> addCustomer(@RequestBody CustomerRequestDto dto){
        try {
            CustomerResponseDto customerResponseDto = customerService.addNew(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(customerResponseDto);
        } catch (CustomerCreateException e) {
            return ResponseEntity.internalServerError().build();
        }
    }



}
