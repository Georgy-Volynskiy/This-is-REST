package ru.kata.spring.boot_security.demo.dto;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Objects;
import java.util.Set;

public final class UserCreateUpdateDto {

    private final String email;
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String rawPassword;
    private final Set<Role> roles;

    public UserCreateUpdateDto(String email, String firstName, String lastName, Integer age, String rawPassword, Set<Role> roles) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.rawPassword = rawPassword;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateUpdateDto that = (UserCreateUpdateDto) o;
        return Objects.equals(email, that.email) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(age, that.age) && Objects.equals(rawPassword, that.rawPassword) && Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, age, rawPassword, roles);
    }

    @Override
    public String toString() {
        return "UserCreateUpdateDto{" +
               "email='" + email + '\'' +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", age=" + age +
               ", rawPassword='" + rawPassword + '\'' +
               ", rolesId=" + roles +
               '}';
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

    public Integer getAge() {
        return age;
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
