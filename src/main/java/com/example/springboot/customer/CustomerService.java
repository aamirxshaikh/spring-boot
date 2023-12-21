package com.example.springboot.customer;

import com.example.springboot.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer getCustomer(Long id) {
    return customerRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Customer not found with ID " + id));
  }

  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }
}
