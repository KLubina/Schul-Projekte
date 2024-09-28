package com.example.jwt.domain.county;

import com.example.jwt.core.generic.ExtendedRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {

    // Query method to find country by name or abbreviation
    Optional<Country> findByCountryNameOrAbbreviation(String countryName, String abbreviation);

    // Check if a country exists by name or abbreviation
    boolean existsByCountryNameOrAbbreviation(String countryName, String abbreviation);
}
