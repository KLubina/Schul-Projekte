package com.example.jwt.domain.rank;

import com.example.jwt.core.generic.ExtendedAuditEntity;
import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.domain.role.Role;
import com.example.jwt.domain.user.User;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "rank")
public class Rank extends ExtendedEntity {

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "seedsNeeded", nullable = false)
    private int seedsNeeded;
    @Column(name = "reduction", nullable = false)
    private int reduction;
    @OneToMany(mappedBy = "rank", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();


    public Rank() {
    }
    public Rank(UUID id, String title, int seedsNeeded, int reduction) {
        super(id);
        this.title = title;
        this.seedsNeeded = seedsNeeded;
        this.reduction = reduction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeedsNeeded() {
        return seedsNeeded;
    }

    public void setSeedsNeeded(int seedsNeeded) {
        this.seedsNeeded = seedsNeeded;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
