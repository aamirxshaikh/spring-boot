package com.example.springboot.customer;

import com.example.springboot.exception.NotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@ActiveProfiles("test")
class CustomerServiceTest {
  @Autowired
  private CustomerRepository customerRepository;

  private CustomerService customerService;

  @BeforeEach
  void setUp() {
    customerService = new CustomerService(customerRepository);
  }

  @AfterEach
  void tearDown() {
    customerRepository.deleteAll();
  }

  @Test
  @DirtiesContext
  void getCustomer() {
    // given
    Customer john = new Customer(1L, "John", "Doe", "john@gmail.com", "John@123");

    customerRepository.save(john);

    // when
    Customer customer = customerService.getCustomer(1L);

    // then
    assertEquals(john.getId(), customer.getId());
    assertEquals(john.getFirstName(), customer.getFirstName());
    assertEquals(john.getLastName(), customer.getLastName());
    assertEquals(john.getEmail(), customer.getEmail());
    assertEquals(john.getPassword(), customer.getPassword());
  }

  @Test
  @DirtiesContext
  void getCustomerNotFound() {
    // Given no customers in repository

    // When & Then
    assertThrows(NotFoundException.class, () -> customerService.getCustomer(1L));
  }

  @Test
  @DirtiesContext
  void getCustomers() {
    // given
    Customer john = new Customer(1L, "John", "Doe", "john@gmail.com", "John@123");
    Customer jane = new Customer(2L, "Jane", "Doe", "jane@gmail.com", "Jane@123");

    customerRepository.saveAll(Arrays.asList(john, jane));

    // when
    List<Customer> customers = customerService.getCustomers();

    // then
    assertEquals(2, customers.size());

    Customer firstCustomer = customers.get(0);
    assertEquals(john.getId(), firstCustomer.getId());
    assertEquals(john.getFirstName(), firstCustomer.getFirstName());
    assertEquals(john.getLastName(), firstCustomer.getLastName());
    assertEquals(john.getEmail(), firstCustomer.getEmail());
    assertEquals(john.getPassword(), firstCustomer.getPassword());

    Customer secondCustomer = customers.get(1);
    assertEquals(jane.getId(), secondCustomer.getId());
    assertEquals(jane.getFirstName(), secondCustomer.getFirstName());
    assertEquals(jane.getLastName(), secondCustomer.getLastName());
    assertEquals(jane.getEmail(), secondCustomer.getEmail());
    assertEquals(jane.getPassword(), secondCustomer.getPassword());
  }
}