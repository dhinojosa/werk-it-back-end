package com.xyzcorp.domain.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Weights {

    @Id
    @GeneratedValue
    private Long id;
    private int sets;
    private int reps;
    private int pounds;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public int getPounds() {
        return pounds;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weights weights = (Weights) o;
        return sets == weights.sets && reps == weights.reps && pounds == weights.pounds && Objects.equals(id, weights.id) && Objects.equals(name, weights.name) && Objects.equals(user, weights.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sets, reps, pounds, name, user);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Weights.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("sets=" + sets)
            .add("reps=" + reps)
            .add("pounds=" + pounds)
            .add("name='" + name + "'")
            .add("user=" + user)
            .toString();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
