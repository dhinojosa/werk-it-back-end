package com.xyzcorp.domain.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Aerobics {

    @Id
    @GeneratedValue
    private Long id;
    private int seconds;
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


    public int getSeconds() {
        return seconds;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aerobics aerobics = (Aerobics) o;
        return seconds == aerobics.seconds && Objects.equals(id, aerobics.id) && Objects.equals(name, aerobics.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seconds, name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Aerobics.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("seconds=" + seconds)
            .add("name='" + name + "'")
            .toString();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
