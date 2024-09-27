package com.example.jwt.domain.teaType;

import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.domain.tea.Tea;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tea_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeaType extends ExtendedEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "minAge", nullable = true)
    private Integer minAge;  // Verwenden Sie Integer statt int für Null-Werte

    @OneToMany(mappedBy = "teaType", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Tea> teas = new HashSet<>();

    // Zusätzliche Methoden (falls erforderlich)
    public void addTea(Tea tea) {
        teas.add(tea);
        tea.setTeaType(this);
    }

    public void removeTea(Tea tea) {
        teas.remove(tea);
        tea.setTeaType(null);
    }
}
