package com.xyzcorp.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(firstName,
            user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, password);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
            .add("email='" + email + "'")
            .add("firstName='" + firstName + "'")
            .add("lastName='" + lastName + "'")
            .add("password='" + password + "'")
            .toString();
    }
}
