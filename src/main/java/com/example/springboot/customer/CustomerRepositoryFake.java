package com.example.springboot.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepositoryFake implements CustomerRepository {
  @Override
  public List<Customer> getCustomers() {
    return Arrays.asList(
            new Customer(1L, "John", "Doe", "john.doe@test.com", "john123"),
            new Customer(2L, "Jane", "Doe", "jane.doe@test.com", "jane123"),
            new Customer(3L, "James", "Doe", "james.doe@test.com", "james123")
    );
  }
}
