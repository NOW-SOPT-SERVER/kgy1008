package org.example.domain;

public class Account {
    private String accountNumber;
    private Long deposit;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.deposit = 0L;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public Long getDeposit() {
        return this.deposit;
    }
}
