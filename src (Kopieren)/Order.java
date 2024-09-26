package com.example.jwt.domain.orders;

import com.example.jwt.core.generic.ExtendedEntity;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

import com.example.jwt.domain.tea.Tea;

@Entity
@Table(name = "orders")
public class Order extends ExtendedEntity {

    @Column(name = "pId", nullable = false)
    private UUID pId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tea_id", nullable = false)  // This will replace the teaId column
    private Tea tea;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "pricePayed", nullable = false)
    private int pricePayed;

    @Column(name = "orderDate", nullable = false)
    private Date orderDate;

    public Order() {
    }


    public Order(UUID id, UUID pId, Tea tea, int amount, int pricePayed, Date orderDate) {
        super(id);
        this.pId = pId;
        this.tea = tea;
        this.amount = amount;
        this.pricePayed = pricePayed;
        this.orderDate = orderDate;
    }

    public UUID getpId() {
        return pId;
    }

    public void setpId(UUID pId) {
        this.pId = pId;
    }

    public Tea getTea() {
        return tea;
    }

    public void setTea(Tea tea) {
        this.tea = tea;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPricePayed() {
        return pricePayed;
    }

    public void setPricePayed(int pricePayed) {
        this.pricePayed = pricePayed;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}


