package com.example.jwt.domain.user;

import ch.qos.logback.classic.Logger;
import com.example.jwt.domain.county.Country;
import com.example.jwt.domain.county.CountryRepository;
import com.example.jwt.domain.rank.Rank;
import com.example.jwt.domain.rank.RankRepository;
import com.example.jwt.domain.role.Role;
import com.example.jwt.domain.role.RoleRepository;
import com.example.jwt.domain.user.dto.UserDTO;
import com.example.jwt.domain.user.dto.UserMapper;
import com.example.jwt.domain.user.dto.UserRegisterDTO;
import jakarta.validation.Valid;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;
  private final UserMapper userMapper;
  private final CountryRepository countryRepository;
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;  // Inject the RoleRepository
  private final RankRepository rankRepository;

  @Autowired
  public UserController(UserService userService, UserMapper userMapper, UserRepository userRepository,
                        CountryRepository countryRepository, RoleRepository roleRepository,
                        RankRepository rankRepository) {
    this.userService = userService;
    this.userMapper = userMapper;
    this.userRepository = userRepository;
    this.countryRepository = countryRepository;
    this.roleRepository = roleRepository;
    this.rankRepository = rankRepository;
  }

  @GetMapping("/profile")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<UserDTO> getProfile() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    User user = userDetails.user();
    return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> retrieveById(@PathVariable UUID id) {
    User user = userService.findById(id);
    return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
  }

  @GetMapping({"", "/"})
  public ResponseEntity<List<UserDTO>> retrieveAll() {
    List<User> users = userService.findAll();
    return new ResponseEntity<>(userMapper.toDTOs(users), HttpStatus.OK);
  }

  @PostMapping("/register")
  public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {

    // MAP GIVEN PARAMETERS FROM USER_REGISTER_DTO
    User user = userMapper.fromUserRegisterDTO(userRegisterDTO);

    // FIND COUNTRY IN DB BY NAME OR ABBREVIATION
    Optional<Country> countryOptional = countryRepository.findByCountryNameOrAbbreviation(
            userRegisterDTO.getCountryNameOrAbbreviation(),
            userRegisterDTO.getCountryNameOrAbbreviation()
    );

    if (countryOptional.isEmpty()) {
      throw new IllegalArgumentException("Invalid country name or abbreviation");
    }
    Country country = countryOptional.get();

    // CLIENT ROLE
    Optional<Role> clientRoleOptional = roleRepository.findByName("CLIENT");
    if (clientRoleOptional.isEmpty()) {
      throw new IllegalArgumentException("CLIENT role not found");
    }
    Role clientRole = clientRoleOptional.get();

    // COUNTRY + ROLE
    user.setCountry(country);
    Set<Role> roles = new HashSet<>();
    roles.add(clientRole);
    user.setRoles(roles);

    // GET SILVER RANK FROM DB
    Optional<Rank> silverRankOptional = rankRepository.findByTitle("Silver");
    if (silverRankOptional.isEmpty()) {
      throw new IllegalArgumentException("Silver rank not found");
    }
    Rank silverRank = silverRankOptional.get();

    // GIVE USER SILVER RANK
    user.setRank(silverRank);

    // PASSWORD ENCRYPT
    userService.register(user);

    // DTO CONVERT
    UserDTO userDTO = userMapper.toDTO(user);
    return ResponseEntity.ok(userDTO);
  }

}
