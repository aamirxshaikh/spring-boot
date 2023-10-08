package com.example.springboot.configuration;

import com.example.springboot.customer.CustomerRepository;
import com.example.springboot.customer.CustomerRepositoryFake;
import com.example.springboot.customer.CustomerRepositoryImpl;
import com.example.springboot.product.ProductRepository;
import com.example.springboot.product.ProductRepositoryFake;
import com.example.springboot.product.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
  @Value("${app.useFakeProductRepository:false}")
  private Boolean useFakeProductRepository;

  @Value("${app.useFakeCustomerRepository:false}")
  private Boolean useFakeCustomerRepository;

  @Bean
  ProductRepository productRepository() {
    System.out.println("useFakeRepository - " + useFakeProductRepository);
    return useFakeProductRepository ?
            new ProductRepositoryFake() :
            new ProductRepositoryImpl();
  }

  @Bean
  CustomerRepository customerRepository() {
    System.out.println("useFakeRepository - " + useFakeCustomerRepository);
    return useFakeCustomerRepository ?
            new CustomerRepositoryFake() :
            new CustomerRepositoryImpl();
  }
}
