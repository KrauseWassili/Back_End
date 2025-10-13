package de.aittr.product.exception;

import de.aittr.product.model.Product;

public class CustomerCreateException extends RuntimeException{
    public CustomerCreateException(Product product) {
        super(product.toString());
    }
}
