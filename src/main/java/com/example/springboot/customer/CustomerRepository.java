package com.example.springboot.customer;

import java.util.List;

public interface CustomerRepository {
  List<Customer> getCustomers();
}
