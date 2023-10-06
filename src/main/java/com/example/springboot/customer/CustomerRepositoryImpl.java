package com.example.springboot.customer;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
  @Override
  public List<Customer> getCustomers() {
    return Collections.emptyList();
  }
}
