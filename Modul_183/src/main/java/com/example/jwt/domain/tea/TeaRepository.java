package com.example.jwt.domain.tea;

import com.example.jwt.core.generic.ExtendedRepository;

import java.util.Optional;


public interface TeaRepository extends ExtendedRepository<Tea> {
    Optional<Tea> findByName(String name);
}
