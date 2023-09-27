package com.example.springboot.product;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositoryFake implements ProductRepository {
  @Override
  public List<Product> getProducts() {
    return Arrays.asList(
            new Product(1L, "Product 1", 1200.99, "key1"),
            new Product(2L, "Product 2", 1400.99, "key2"),
            new Product(3L, "Product 3", 1700.99, "key3")
    );
  }
}
