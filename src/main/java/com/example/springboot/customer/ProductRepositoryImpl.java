package com.example.springboot.customer;

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
}
