package com.example.springboot.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
class ProductServiceTest {
  @Autowired
  private ProductRepository productRepository;

  private ProductService productService;

  @BeforeEach
  void setUp() {
    productService = new ProductService(productRepository);
  }

  @AfterEach
  void tearDown() {
    productRepository.deleteAll();
  }

  @Test
  void getProducts() {
    // given
    Product product = new Product(1L, "Product 1", 199.0, "secret", false);
    Product product2 = new Product(2L, "Product 2", 299.0, "secret2", true);
    Product product3 = new Product(3L, "Product 3", 399.0, "secret3", false);

    productRepository.saveAll(Arrays.asList(product, product2, product3));

    // when
    List<Product> products = productService.getProducts();

    // then
    assertEquals(3, products.size());

    Product firstProduct = products.get(0);
    assertEquals(product.getId(), firstProduct.getId());
    assertEquals(product.getName(), firstProduct.getName());
    assertEquals(product.getPrice(), firstProduct.getPrice());
    assertEquals(product.getSecretKey(), firstProduct.getSecretKey());
    assertEquals(product.getFeatured(), firstProduct.getFeatured());

    Product secondProduct = products.get(1);
    assertEquals(product2.getId(), secondProduct.getId());
    assertEquals(product2.getName(), secondProduct.getName());
    assertEquals(product2.getPrice(), secondProduct.getPrice());
    assertEquals(product2.getSecretKey(), secondProduct.getSecretKey());
    assertEquals(product2.getFeatured(), secondProduct.getFeatured());

    Product thirdProduct = products.get(2);
    assertEquals(product3.getId(), thirdProduct.getId());
    assertEquals(product3.getName(), thirdProduct.getName());
    assertEquals(product3.getPrice(), thirdProduct.getPrice());
    assertEquals(product3.getSecretKey(), thirdProduct.getSecretKey());
    assertEquals(product3.getFeatured(), thirdProduct.getFeatured());
  }

  @Test
  void getFeaturedProducts() {
    // given
    Product product = new Product(1L, "Product 1", 199.0, "secret", false);
    Product product2 = new Product(2L, "Product 2", 299.0, "secret2", true);
    Product product3 = new Product(3L, "Product 3", 399.0, "secret3", false);

    productRepository.saveAll(Arrays.asList(product, product2, product3));

    // when
    List<Product> products = productService.getFeaturedProducts();

    // then
    assertEquals(1, products.size());

    Product featuredProduct = products.get(0);
    assertEquals(product2.getId(), featuredProduct.getId());
    assertEquals(product2.getName(), featuredProduct.getName());
    assertEquals(product2.getPrice(), featuredProduct.getPrice());
    assertEquals(product2.getSecretKey(), featuredProduct.getSecretKey());
    assertEquals(product2.getFeatured(), featuredProduct.getFeatured());
  }
}