package com.example.springboot.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  List<Customer> getCustomers() {
    return customerService.getCustomers();
  }

  @PostMapping
  public void createCustomer(@RequestBody Customer customer) {
    System.out.println("POST");
    System.out.println(customer);
  }

  @PutMapping("{id}")
  public void updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
    System.out.println("PUT");
    System.out.println(id);
    System.out.println(customer);
  }

  @DeleteMapping("{id}")
  public void deleteCustomer(@PathVariable("id") Long id) {
    System.out.println("DELETE");
    System.out.println(id);
  }
}
