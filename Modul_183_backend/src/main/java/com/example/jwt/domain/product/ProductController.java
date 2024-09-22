package com.example.jwt.domain.product;

import com.example.jwt.domain.tea.TeaService;
import com.example.jwt.domain.tea.dto.TeaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final TeaService teaService;

    @Autowired
    public ProductController(TeaService teaService) {
        this.teaService = teaService;
    }

    @PreAuthorize("hasAuthority('CAN_RETRIEVE_PRODUCTS')")
    @GetMapping
    public ResponseEntity<List<TeaDTO>> getAllTeas() {
        List<TeaDTO> teas = teaService.getAllTeas();
        return ResponseEntity.ok(teas);
    }
}
