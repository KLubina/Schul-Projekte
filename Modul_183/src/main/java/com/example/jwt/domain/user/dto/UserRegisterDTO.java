package com.example.jwt.domain.user.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.core.security.validators.age.ValidAge;
import com.example.jwt.core.security.validators.country.ValidCountry;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO extends ExtendedDTO {

  @NotBlank(message = "{user.firstName.notBlank}")
  private String firstName;

  @NotBlank(message = "{user.lastName.notBlank}")
  private String lastName;

  @Email
  private String email;

  @NotBlank(message = "{user.password.notBlank}")
  @Size(min = 8, message = "{user.password.size}")
  private String password;

  @NotNull(message = "{user.age.notNull}")
  @ValidAge
  private Integer age;

  @NotBlank(message = "{user.country.notBlank}")
  @ValidCountry(message = "{user.country.invalid}")
  private String countryNameOrAbbreviation;

  public UserRegisterDTO() {
  }

  public UserRegisterDTO(String firstName, String lastName, String email, String password, Integer age, String countryNameOrAbbreviation) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.age = age;
    this.countryNameOrAbbreviation = countryNameOrAbbreviation;
  }

  public String getFirstName() {
    return firstName;
  }

  public UserRegisterDTO setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public UserRegisterDTO setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserRegisterDTO setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserRegisterDTO setPassword(String password) {
    this.password = password;
    return this;
  }

  public Integer getAge() {
    return age;
  }

  public UserRegisterDTO setAge(Integer age) {
    this.age = age;
    return this;
  }

  public String getCountryNameOrAbbreviation() {
    return countryNameOrAbbreviation;
  }

  public void setCountryNameOrAbbreviation(String countryNameOrAbbreviation) {
    this.countryNameOrAbbreviation = countryNameOrAbbreviation;
  }
}
