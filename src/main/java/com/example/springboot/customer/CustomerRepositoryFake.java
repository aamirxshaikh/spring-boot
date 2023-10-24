package com.example.springboot.customer;

import com.example.springboot.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CustomerRepositoryFake implements CustomerRepository {
  private final List<Customer> fakeCustomers = Arrays.asList(
          new Customer(1L, "John", "Doe", "john.doe@test.com", "john123"),
          new Customer(2L, "Jane", "Doe", "jane.doe@test.com", "jane123"),
          new Customer(3L, "James", "Doe", "james.doe@test.com", "james123")
  );

  @Override
  public Customer getCustomer(Long id) {
    return getCustomers()
            .stream()
            .filter(customer -> customer.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new NotFoundException("Customer with id " + id + " not found"));
  }

  @Override
  public List<Customer> getCustomers() {
    return fakeCustomers;
  }
}
