package de.aittr.product.exception;

import de.aittr.product.model.Product;

public class ProductCreateException extends RuntimeException{
    public ProductCreateException(Product product) {
        super(product.toString());
    }
}
