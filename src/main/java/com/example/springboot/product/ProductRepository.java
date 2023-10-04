package com.example.springboot.product;

import java.util.List;

public interface ProductRepository {
  List<Product> getProducts();

  List<Product> getFeaturedProducts();
}
