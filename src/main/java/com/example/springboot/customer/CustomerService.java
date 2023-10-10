package com.example.springboot.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerService(@Qualifier("customerRepositoryFake") CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> getCustomers() {
    return customerRepository.getCustomers();
  }
}