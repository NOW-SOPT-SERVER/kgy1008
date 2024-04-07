package org.example.domain;

public class Account {
    private String accountNumber;
    private Long amount;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.amount = 0L;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(Long amount) {
        if (amount > 0) {
            this.amount += amount;
        } else {
            throw new IllegalArgumentException("입금 금액은 0보다 커야합니다.");
        }
    }
}
