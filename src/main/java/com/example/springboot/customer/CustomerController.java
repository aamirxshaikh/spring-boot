package com.example.springboot.customer;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{id}")
  Customer getCustomer(@PathVariable Long id) {
    return customerService.getCustomer(id);
  }

  @GetMapping
  List<Customer> getCustomers() {
    return customerService.getCustomers();
  }

  @PostMapping
  public void createCustomer(@Valid @RequestBody Customer customer) {
    LOGGER.info("POST");
    LOGGER.info("customer : {}", customer);
  }

  @PutMapping("{id}")
  public void updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
    LOGGER.info("PUT");
    LOGGER.info("customer id : {}", id);
    LOGGER.info("customer : {}", customer);
  }

  @DeleteMapping("{id}")
  public void deleteCustomer(@PathVariable("id") Long id) {
    LOGGER.info("DELETE");
    LOGGER.info("customer id : {}", id);
  }
}
