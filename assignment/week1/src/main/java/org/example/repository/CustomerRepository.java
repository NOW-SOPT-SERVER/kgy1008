package org.example.repository;

import org.example.domain.User;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private List<User> users;

    public CustomerRepository() {
        this.users = new ArrayList<>();
    }

    public User findUserByRegistrationNumber(String registrationNumber) {
        for (User user : users) {
            if (user.getRegistrationNumber().equals(registrationNumber)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }

    public List<User> getUsers() {
        return this.users;
    }
}
