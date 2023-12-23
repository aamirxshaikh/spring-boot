package com.example.springboot.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Name must not be empty")
  private String name;

  @NotNull(message = "Price must not be empty")
  @DecimalMin(value = "0.0")
  private Double price;

  @NotBlank(message = "Secret key must not be empty")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String secretKey;

  @NotNull(message = "Featured must not be null")
  @Pattern(regexp = "^(true|false)$", message = "Featured must be either true or false")
  private Boolean featured;

  public Product() {
  }

  public Product(Long id, String name, Double price, String secretKey, Boolean featured) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.secretKey = secretKey;
    this.featured = featured;
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

  @JsonIgnore
  public Boolean getFeatured() {
    return featured;
  }

  @Override
  public String toString() {
    return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", secretKey='" + secretKey + '\'' +
            ", featured=" + featured +
            '}';
  }
}
