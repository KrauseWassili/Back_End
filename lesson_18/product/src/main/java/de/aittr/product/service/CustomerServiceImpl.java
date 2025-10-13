package de.aittr.product.service;

import de.aittr.product.dto.*;
import de.aittr.product.exception.CustomerNotFoundException;
import de.aittr.product.exception.ProductNotFoundException;
import de.aittr.product.mapper.AddressMapper;
import de.aittr.product.mapper.CartMapper;
import de.aittr.product.mapper.CustomerMapper;
import de.aittr.product.model.Address;
import de.aittr.product.model.Cart;
import de.aittr.product.model.Customer;
import de.aittr.product.model.Product;
import de.aittr.product.repository.AddressRepository;
import de.aittr.product.repository.CustomerRepository;
import de.aittr.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final CustomerMapper customerMapper;
    private  final AddressMapper addressMapper;
    private final CartMapper cartMapper;

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

    @Transactional
    public CustomerResponseDto addAddress(Long id, AddressRequestDto dto){
        Customer customer = customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException(id));
        Address address = addressMapper.fromDto(dto);
        address.setCustomer(customer);
        Address savedAddress = addressRepository.save(address);

        // добавляем адрес кастомеру
        //   List<Address> addresses = customer.getAddresses();
        //  addresses.add(savedAddress);
        return customerMapper.toDto(customer);
    }

    @Transactional
    public CartResponseDto addProductToCart(Long customerId, Long productId){
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
        Cart cart = customer.getCart();
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        cart.addProduct(product);
        return  cartMapper.toDto(cart);
    }


    public List<CustomerResponseDto> getAllCustomers() {
        return customerMapper.toDto(customerRepository.findAll());
    }

}
