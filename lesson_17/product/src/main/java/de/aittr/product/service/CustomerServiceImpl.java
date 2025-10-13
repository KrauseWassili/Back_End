package de.aittr.product.service;

import de.aittr.product.dto.CustomerRequestDto;
import de.aittr.product.dto.CustomerResponseDto;
import de.aittr.product.mapper.CustomerMapper;
import de.aittr.product.model.Address;
import de.aittr.product.model.Cart;
import de.aittr.product.model.Customer;
import de.aittr.product.model.Product;
import de.aittr.product.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    public CustomerResponseDto addNew(CustomerRequestDto dto){
        Customer customer = customerMapper.fromDto(dto);
        customer.setActive(true);
        List<Product> products = new ArrayList<>();
        Cart cart = new Cart(null, customer,products);
        customer.setCart(cart);
        List<Address> addresses = new ArrayList<>();
        customer.setAddresses(addresses);
        Customer saved = customerRepository.save(customer);
        return  customerMapper.toDto(saved);
    }


}
