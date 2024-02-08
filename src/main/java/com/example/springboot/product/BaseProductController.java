package com.example.springboot.product;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseProductController {
  private static final Logger LOGGER = LoggerFactory.getLogger(BaseProductController.class);

  protected final ProductService productService;

  @Autowired
  protected BaseProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<Product> getProducts() {
    return productService.getProducts();
  }

  @PostMapping
  public void createProduct(@Valid @RequestBody Product product) {
    LOGGER.info("POST");
    LOGGER.info("product : {}", product);
  }

  @PutMapping("{id}")
  public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
    LOGGER.info("PUT");
    LOGGER.info("id : {}", id);
    LOGGER.info("product : {}", product);
  }

  @DeleteMapping("{id}")
  public void deleteProduct(@PathVariable("id") Long id) {
    LOGGER.info("DELETE");
    LOGGER.info("id : {}", id);
  }
}
