package com.example.springboot.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customer {
  private final Long id;

  @NotBlank(message = "First name must not be empty")
  private final String firstName;

  @NotBlank(message = "Last name must not be empty")
  private final String lastName;

  @NotBlank(message = "Email must not be empty")
  @Email(message = "Email must be valid")
  private final String email;

  @NotBlank(message = "Password must not be empty")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private final String password;

  public Customer(Long id, String firstName, String lastName, String email, String password) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  @JsonIgnore
  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
