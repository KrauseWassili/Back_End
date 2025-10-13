package de.aittr.product.exception;

import de.aittr.product.dto.ProductRequestDto;

public class ProductIncorrectEntryException extends RuntimeException {
    public ProductIncorrectEntryException(ProductRequestDto productRequestDto) {

        super("Incorrect entry: title: %s, price: %s, active: %s".formatted(productRequestDto.getTitle(),productRequestDto.getPrice(),productRequestDto.isActive()));
    }
}
