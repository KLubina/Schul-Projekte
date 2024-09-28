package com.example.jwt.domain.county;

import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.domain.user.User;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "country")
public class Country extends ExtendedEntity {

    @Column(name = "countryName", nullable = false)
    private String countryName;  // Corrected typo from 'countyName' to 'countryName'

    @Column(name = "abbreviation", nullable = false)
    private String abbreviation;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    public Country() {
    }

    public Country(UUID id, String countryName, String abbreviation) {
        super(id);
        this.countryName = countryName;
        this.abbreviation = abbreviation;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


}
