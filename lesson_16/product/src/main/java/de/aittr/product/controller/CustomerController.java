package de.aittr.product.controller;

import de.aittr.product.dto.CustomerRequestDto;
import de.aittr.product.dto.CustomerResponseDto;
import de.aittr.product.exception.CustomerCreateException;
import de.aittr.product.exception.CustomerNotFoundException;
import de.aittr.product.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/customers")
@RequiredArgsConstructor
@RestController
public class CustomerController {
    private final CustomerService service;

    @GetMapping()
    public ResponseEntity<List<CustomerResponseDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @PostMapping()
    public ResponseEntity<CustomerResponseDto> addCustomer(@RequestBody CustomerRequestDto dto) {
        try {
            CustomerResponseDto customerResponseDto = service.addCustomer(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(customerResponseDto);
        } catch (CustomerCreateException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity<?> setActive(
            @PathVariable(name = "id") long customerId,
            @PathVariable(name = "status") String status
    ) {
        if (status.equalsIgnoreCase("active") || status.equalsIgnoreCase("not-active"))
            try {
                if (status.equalsIgnoreCase("active")) {
                    return ResponseEntity.status(HttpStatus.OK).body(service.setActiveById(customerId, true));
                } else
                    return ResponseEntity.status(HttpStatus.OK).body(service.setActiveById(customerId, false));


            } catch (CustomerNotFoundException e) {
                return ResponseEntity.internalServerError().build();

            }
        return null;

    }
}