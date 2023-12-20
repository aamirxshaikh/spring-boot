package com.example.springboot.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Primary
public class CustomerRepositoryImpl implements CustomerRepository {
  @Override
  public Customer getCustomer(Long id) {
    return null;
  }

  @Override
  public List<Customer> getCustomers() {
    return Collections.emptyList();
  }
}
