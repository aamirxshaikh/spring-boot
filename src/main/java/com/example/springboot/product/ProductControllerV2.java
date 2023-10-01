package com.example.springboot.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/products")
public class ProductControllerV2 {
  private final ProductService productService;

  @Autowired
  public ProductControllerV2(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  List<Product> getProducts() {
    return productService.getProducts();
  }

  @PostMapping
  void createProduct(@RequestBody Product product) {
    System.out.println("POST");
    System.out.println(product);
  }

  @PutMapping("{id}")
  void updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
    System.out.println("PUT");
    System.out.println(id);
    System.out.println(product);
  }

  @DeleteMapping("{id}")
  void deleteProduct(@PathVariable("id") Long id) {
    System.out.println("DELETE");
    System.out.println(id);
  }

  @GetMapping("/featured")
  List<Product> getFeaturedProducts() {
    return productService.getFeaturedProducts();
  }
}
