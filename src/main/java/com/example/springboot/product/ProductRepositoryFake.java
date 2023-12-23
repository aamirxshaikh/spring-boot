package com.example.springboot.product;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryFake implements ProductRepository {
  @Override
  public List<Product> getProducts() {
    return Arrays.asList(
            new Product(1L, "Product 1", 1200.99, "key1", true),
            new Product(2L, "Product 2", 1400.99, "key2", false),
            new Product(3L, "Product 3", 1700.99, "key3", false)
    );
  }

  @Override
  public List<Product> getFeaturedProducts() {
    return getProducts().stream()
            .filter(Product::getFeatured)
            .collect(Collectors.toList());
  }
}