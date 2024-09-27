package com.example.jwt.domain.orders.dto;

import java.util.Date;
import java.util.UUID;

public class UserOrderDTO {

    private UUID orderId;
    private String teaName;
    private int amountInGrams;
    private int pricePaid;
    private Date orderDate;

    public UserOrderDTO(UUID orderId, String teaName, int amountInGrams, int pricePaid, Date orderDate) {
        this.orderId = orderId;
        this.teaName = teaName;
        this.amountInGrams = amountInGrams;
        this.pricePaid = pricePaid;
        this.orderDate = orderDate;
    }

    // Getters and setters
    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public int getAmountInGrams() {
        return amountInGrams;
    }

    public void setAmountInGrams(int amountInGrams) {
        this.amountInGrams = amountInGrams;
    }

    public int getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(int pricePaid) {
        this.pricePaid = pricePaid;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
