package com.example.jwt.domain.tea;

import com.example.jwt.domain.tea.dto.TeaDTO;

import java.util.List;
import java.util.Optional;

public interface TeaService {

    List<TeaDTO> getAllTeas();
    Optional<Tea> findByName(String name);

}
