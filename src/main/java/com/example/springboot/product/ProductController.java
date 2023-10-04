package com.example.springboot.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController extends BaseProductController {
  public ProductController(ProductService productService) {
    super(productService);
  }
}
