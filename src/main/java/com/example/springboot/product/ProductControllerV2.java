package com.example.springboot.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/products")
public class ProductControllerV2 extends BaseProductController {
  public ProductControllerV2(ProductService productService) {
    super(productService);
  }

  @GetMapping("/featured")
  public List<Product> getFeaturedProducts() {
    return productService.getFeaturedProducts();
  }
}
