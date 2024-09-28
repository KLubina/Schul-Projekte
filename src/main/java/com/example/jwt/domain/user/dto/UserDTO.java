package com.example.jwt.domain.user.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.domain.role.dto.RoleDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

import java.util.Set;
import java.util.UUID;

public class UserDTO extends ExtendedDTO {

  private String firstName;

  private String lastName;

  @Email
  private String email;

  @Valid
  private Set<RoleDTO> roles;

  private Integer age;

  // Add the countryName field here
  private String countryName;

  public UserDTO() {
  }

  public UserDTO(UUID id, String firstName, String lastName, String email, Set<RoleDTO> roles, Integer age, String countryName) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.roles = roles;
    this.age = age;
    this.countryName = countryName;  // Initialize country name
  }

  public String getFirstName() {
    return firstName;
  }

  public UserDTO setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public UserDTO setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserDTO setEmail(String email) {
    this.email = email;
    return this;
  }

  public Set<RoleDTO> getRoles() {
    return roles;
  }

  public UserDTO setRoles(Set<RoleDTO> roles) {
    this.roles = roles;
    return this;
  }

  public Integer getAge() {
    return age;
  }

  public UserDTO setAge(Integer age) {
    this.age = age;
    return this;
  }

  // Getter and Setter for countryName
  public String getCountryName() {
    return countryName;
  }

  public UserDTO setCountryName(String countryName) {
    this.countryName = countryName;
    return this;
  }
}
