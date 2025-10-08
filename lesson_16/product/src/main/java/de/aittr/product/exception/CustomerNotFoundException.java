package de.aittr.product.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {

        super("Product %d not found".formatted(id));
    }
}
