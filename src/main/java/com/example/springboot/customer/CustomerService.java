package com.example.springboot.customer;

import com.example.springboot.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer getCustomer(Long id) {
    return customerRepository.findById(id)
            .orElseThrow(() -> {
              NotFoundException notFoundException = new NotFoundException("Customer not found with ID " + id);

              LOGGER.error(notFoundException.getMessage(), notFoundException);

              return notFoundException;
            });
  }

  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }
}
