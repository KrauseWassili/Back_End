package de.aittr.product.controller;

import de.aittr.product.dto.*;
import de.aittr.product.exception.ApiError;
import de.aittr.product.exception.CustomerNotFoundException;
import de.aittr.product.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAll(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> addNew(@RequestBody CustomerRequestDto dto){
        CustomerResponseDto added = customerService.addNew(dto);

        // заполнение заголовка location
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(added.getId())
                .toUri();

        return ResponseEntity.created(uri).body(added);
        //return ResponseEntity.status(HttpStatus.CREATED).body(added);
    }

    // customers/5/address
    @PostMapping("/{id}/address")
    public ResponseEntity<CustomerResponseDto> addAddress(@PathVariable Long id, @RequestBody AddressRequestDto dto){
        CustomerResponseDto responseDto = customerService.addAddress(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    // customers/customerId/cart/products/productId
    @PostMapping("/{customerId}/cart/products/{productId}")
    public ResponseEntity<CartResponseDto> addProductCart(
            @PathVariable Long customerId,
            @PathVariable Long productId
    ){
        CartResponseDto cartResponseDto = customerService.addProductToCart(customerId, productId);
        return ResponseEntity.ok(cartResponseDto);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiError> customerNotFoundHandler(CustomerNotFoundException ex){
        ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }


}
