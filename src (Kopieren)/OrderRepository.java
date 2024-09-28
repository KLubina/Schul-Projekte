package com.example.jwt.domain.orders;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findBypId(UUID userId);
}
