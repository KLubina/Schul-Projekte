package com.example.jwt.domain.product;

import com.example.jwt.domain.tea.TeaService;
import com.example.jwt.domain.tea.dto.TeaDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller zur Verwaltung von Produkten (Tees).
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final TeaService teaService;

    /**
     * Holt alle verfügbaren Tees.
     *
     * @return eine ResponseEntity mit einer Liste von TeaDTO-Objekten
     */
    @PreAuthorize("hasAuthority('CAN_RETRIEVE_PRODUCTS')")
    @GetMapping
    public ResponseEntity<List<TeaDTO>> getAllTeas() {
        log.info("Abrufen aller Tees");
        List<TeaDTO> teas = teaService.getAllTeas();
        log.debug("Anzahl der abgerufenen Tees: {}", teas.size());
        return ResponseEntity.ok(teas);
    }
}
