package com.example.springboot.product;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Primary
public class ProductRepositoryImpl implements ProductRepository {
  @Override
  public List<Product> getProducts() {
    return Collections.emptyList();
  }

  @Override
  public List<Product> getFeaturedProducts() {
    return Collections.emptyList();
  }
}
