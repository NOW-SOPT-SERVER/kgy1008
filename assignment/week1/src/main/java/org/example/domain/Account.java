package org.example.domain;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private Long amount;

    public Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.amount = 0L;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public Long getAmount() {
        return this.amount;
    }

    public String getAccountHolder(){
        return this.accountHolder;
    }

    public void setAmount(Long amount, boolean flag) {
        validateAmount(amount);
        Long money = this.amount;
        if (flag) {
            this.amount += amount;
        }
        else {
            money -= amount;
            if (money >= 0) {
                this.amount = money;
            }
            else {
                throw new IllegalArgumentException("한도 초과 입니다.");
            }
        }
    }

    private Long validateAmount(Long amount) {
        if (amount >= 0) {
            return amount;
        }
        else {
            throw new IllegalArgumentException("0보다 큰 금액을 입력해주세요.");
        }
    }
}
