package com.example.springboot.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Product {
  private final Long id;

  @NotBlank(message = "Name must not be empty")
  private final String name;

  @NotNull(message = "Price must not be empty")
  @DecimalMin(value = "0.0")
  private final Double price;

  @NotBlank(message = "Secret key must not be empty")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private final String secretKey;

  public Product(Long id, String name, Double price, String secretKey) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.secretKey = secretKey;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  @JsonIgnore
  public String getSecretKey() {
    return secretKey;
  }

  @Override
  public String toString() {
    return "Product{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + ", secretKey='" + secretKey + '\'' + '}';
  }
}
