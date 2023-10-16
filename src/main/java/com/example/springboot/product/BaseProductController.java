package com.example.springboot.product;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseProductController {
  protected final ProductService productService;

  @Autowired
  public BaseProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<Product> getProducts() {
    return productService.getProducts();
  }

  @PostMapping
  public void createProduct(@Valid @RequestBody Product product) {
    System.out.println("POST");
    System.out.println(product);
  }

  @PutMapping("{id}")
  public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
    System.out.println("PUT");
    System.out.println(id);
    System.out.println(product);
  }

  @DeleteMapping("{id}")
  public void deleteProduct(@PathVariable("id") Long id) {
    System.out.println("DELETE");
    System.out.println(id);
  }
}
