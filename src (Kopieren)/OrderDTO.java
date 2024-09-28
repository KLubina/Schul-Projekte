package com.example.jwt.domain.orders.dto;

import jakarta.validation.constraints.NotNull;

public class OrderDTO {

    @NotNull
    private String teaName;  // Name of the tea
    @NotNull
    private int amount;  // Amount in grams

    public OrderDTO() {}

    public OrderDTO(String teaName, int amount) {
        this.teaName = teaName;
        this.amount = amount;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
