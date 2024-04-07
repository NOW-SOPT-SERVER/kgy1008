package org.example.domain;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private Long deposit;

    public Account(String accountNumber, String accountHolder, Long deposit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.deposit = deposit;
    }
}
