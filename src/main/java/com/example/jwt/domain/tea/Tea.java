package com.example.jwt.domain.tea;

import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.domain.teaType.TeaType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "tea")
public class Tea extends ExtendedEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "buyPrice", nullable = false)
    private int buyPrice;

    @Column(name = "sellPrice", nullable = false)
    private int sellPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tea_type_id", nullable = false) // Foreign key for teaType
    private TeaType teaType;

    @Column(name = "harvestDate", nullable = false)
    private Date harvestDate;

    public Tea() {
    }

    public Tea(UUID id, String name, int buyPrice, int sellPrice, TeaType teaType, Date harvestDate) {
        super(id);
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.teaType = teaType;
        this.harvestDate = harvestDate;
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

    public TeaType getTeaType() {
        return teaType;
    }

    public void setTeaType(TeaType teaType) {
        this.teaType = teaType;
    }

    public Date getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(Date harvestDate) {
        this.harvestDate = harvestDate;
    }
}
