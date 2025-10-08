package de.aittr.product.service;

import de.aittr.product.dto.CustomerRequestDto;
import de.aittr.product.dto.CustomerResponseDto;
import de.aittr.product.mapper.CustomerMapper;
import de.aittr.product.model.Customer;
import de.aittr.product.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public List<CustomerResponseDto> getAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public CustomerResponseDto getById(long id) {
        return mapper.toDto(repository.findById(id));
    }

    @Override
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
        return mapper.toDto(repository.save(mapper.fromDto(customerRequestDto)));
    }

    @Override
    public CustomerResponseDto setActiveById(long id, boolean status) {
        Customer tempCustomer = repository.findById(id);
        Customer editedCustomer = new Customer(tempCustomer.getId(), tempCustomer.getName(), status);
        return mapper.toDto(repository.save(editedCustomer));
    }


}
