package com.example.jwt.domain.tea.dto;

import java.util.UUID;

public class TeaDTO {

    private UUID id;
    private String name;
    private int buyPrice;
    private int sellPrice;
    private String teaTypeName;

    public TeaDTO() {
    }

    public TeaDTO(UUID id, String name, int buyPrice, int sellPrice, String teaTypeName) {
        this.id = id;
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.teaTypeName = teaTypeName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getTeaTypeName() {
        return teaTypeName;
    }

    public void setTeaTypeName(String teaTypeName) {
        this.teaTypeName = teaTypeName;
    }
}
