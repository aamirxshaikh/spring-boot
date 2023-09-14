package com.example.springboot.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
  private final Long id;
  private final String name;
  private final Double price;

  public Product(Long id, String name, Double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  @JsonProperty("productId")
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getNameAgain() {
    return name;
  }

  @JsonIgnore
  public Double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            '}';
  }
}
