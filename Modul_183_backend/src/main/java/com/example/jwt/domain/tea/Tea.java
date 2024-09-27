package com.example.jwt.domain.tea;

import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.domain.teaType.TeaType;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "tea")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tea extends ExtendedEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "buyPrice", nullable = false)
    private int buyPrice;

    @Column(name = "sellPrice", nullable = false)
    private int sellPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tea_type_id", nullable = false)
    private TeaType teaType;

    @Column(name = "harvestDate", nullable = false)
    private Date harvestDate;

    // Zusätzliche Methoden (falls erforderlich)
    public void updatePrices(int newBuyPrice, int newSellPrice) {
        this.buyPrice = newBuyPrice;
        this.sellPrice = newSellPrice;
    }
}
