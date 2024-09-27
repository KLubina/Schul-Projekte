package com.example.jwt.domain.orders.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    @NotBlank(message = "Tea name is required")
    private String teaName;  // Name of the tea

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be at least 1 gram")
    private Integer amount;  // Amount in grams
}
