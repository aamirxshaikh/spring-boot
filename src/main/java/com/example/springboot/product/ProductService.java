package com.example.springboot.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductService(@Qualifier("productRepositoryFake") ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getProducts() {
    return productRepository.getProducts();
  }

  public List<Product> getFeaturedProducts() {
    return productRepository.getFeaturedProducts();
  }
}
