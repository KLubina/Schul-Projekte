package com.example.jwt.domain.teaType;

import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.domain.tea.Tea;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import java.util.UUID;
import java.util.HashSet;

@Entity
@Table(name = "tea_type")
public class TeaType extends ExtendedEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "minAge", nullable = true)
    private int minAge;

    @OneToMany(mappedBy = "teaType")
    private Set<Tea> teas = new HashSet<>();

    public TeaType() {
    }

    public TeaType(UUID id, String name, Integer minAge, Set<Tea> teas) {
        super(id);
        this.name = name;
        this.minAge = minAge;
        this.teas = teas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Set<Tea> getTeas() {
        return teas;
    }

    public void setTeas(Set<Tea> teas) {
        this.teas = teas;
    }
}
