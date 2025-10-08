package de.aittr.product.repository;

import de.aittr.product.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAll();
    Customer save(Customer customer);
    Customer findById(long id);
}
