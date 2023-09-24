package com.example.springboot.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {
  @Value("${app.useFakeProductRepository:false}")
  private Boolean useFakeProductRepository;

  @Bean
  CommandLineRunner productCommandLineRunner() {
    return args -> System.out.println("Product Command line runner");
  }

  @Bean
  ProductRepository productRepository() {
    System.out.println("useFakeProductRepository - " + useFakeProductRepository);
    return useFakeProductRepository ?
            new ProductRepositoryFake() :
            new ProductRepositoryImpl();
  }
}
