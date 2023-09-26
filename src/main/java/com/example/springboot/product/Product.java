package com.example.springboot.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
  private final Long id;
  private final String name;
  private final Double price;
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
