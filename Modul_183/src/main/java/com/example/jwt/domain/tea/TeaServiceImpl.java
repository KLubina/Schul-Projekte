package com.example.jwt.domain.tea;

import com.example.jwt.domain.tea.dto.TeaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeaServiceImpl implements TeaService {

    private final TeaRepository teaRepository;

    @Autowired
    public TeaServiceImpl(TeaRepository teaRepository) {
        this.teaRepository = teaRepository;
    }

    @Override
    public List<TeaDTO> getAllTeas() {
        return teaRepository.findAll().stream()
                .map(tea -> new TeaDTO(
                        tea.getId(),
                        tea.getName(),
                        tea.getBuyPrice(),
                        tea.getSellPrice(),
                        tea.getTeaType().getName()))  // Get teaType name
                .collect(Collectors.toList());
    }
    @Override
    public Optional<Tea> findByName(String name) {
        return teaRepository.findByName(name);
    }
}
