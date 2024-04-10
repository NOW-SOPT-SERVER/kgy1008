package org.example.domain;

import java.util.List;

public class User {
    private String name;
    private String registrationNumber;
    private List<Account> accounts;

    public User(String name, String registrationNumber, List<Account> accounts) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.accounts = accounts;
    }

    public String getName() {
        return this.name;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }
}
