package com.example.springboot.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {
  @Value("${app.useFakeCustomerRepository:false}")
  private Boolean useFakeProductRepository;

  @Bean
  CommandLineRunner commandLineRunner() {
    return args -> System.out.println("Command line runner");
  }

  @Bean
  ProductRepository productRepository() {
    System.out.println("useFakeProductRepository - " + useFakeProductRepository);
    return useFakeProductRepository ?
            new ProductRepositoryFake() :
            new ProductRepositoryImpl();
  }
}
