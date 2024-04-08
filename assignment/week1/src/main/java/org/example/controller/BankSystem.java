package org.example.controller;

import org.example.domain.Account;
import org.example.domain.UniqueAccountGenerator;
import org.example.domain.BankMenu;
import org.example.domain.User;
import org.example.repository.CustomerRepository;
import org.example.view.InputView;
import org.example.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BankSystem {
    private CustomerRepository customers;

    public BankSystem() {
        this.customers = new CustomerRepository();
    }
    public BankMenu chooseMenu() {
        while (true) {
            try {
                BankMenu menu = BankMenu.extractFunction(InputView.showBankMenu());
                return menu;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public BankMenu executeFunction() {
        BankMenu menu = chooseMenu();
        OutputView.showFunction(menu);
        switch (menu) {
            case ONE:
                createAccount();
                break;
            case TWO:
                deposit();
                break;
            case THREE:
                withdraw();
                break;
            case FOUR:
                accountTransfer();
                break;
            case FIVE:
                displayAccount();
                break;
            case EXIT:
                OutputView.exitSystem();
                break;
        }
        return menu;
    }

    private void createAccount() {
        String accountHolder = InputView.inputName();
        String registrationNumber = InputView.inputRegistrationNumber();
        String accountNumber = UniqueAccountGenerator.generateUniqueAccountNumber();
        Account account = new Account(accountNumber, accountHolder);
        boolean flag = false;

        User existingUser = customers.findUserByRegistrationNumber(registrationNumber);
        if (existingUser != null) {
            flag = true;
            existingUser.getAccounts().add(account);
            OutputView.showAccountResult(flag, accountHolder, accountNumber);
        }
        else {
            List<Account> accounts = new ArrayList<>();
            accounts.add(account);
            User newUser = new User(accountHolder, registrationNumber, accounts);
            customers.addUser(newUser);
            OutputView.showAccountResult(flag, accountHolder, accountNumber);
        }
    }

    private void deposit() {
        String accountNumber;
        Account account = null;
        while (account == null) {
            accountNumber = InputView.inputAccountNumber("");
            account = findAccountByNumber(accountNumber);

            if (account == null) {
                OutputView.printErrorMessage("입력하신 계좌 번호는 존재하지 않습니다. 다시 입력해주세요.");
            }
        }

        long money;
        boolean isValidAmount = false;
        while (!isValidAmount) {
            try {
                money = InputView.inputMoney(account.getAmount());
                account.setAmount(money,true);
                OutputView.showDepositSuccess(money, account.getAmount());
                isValidAmount = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Account findAccountByNumber(String accountNumber) {
        for (User user : customers.getUsers()) {
            for (Account account : user.getAccounts()) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    return account;
                }
            }
        }
        return null;
    }

    private void withdraw() {
        String accountNumber;
        Account account = null;
        while (account == null) {
            accountNumber = InputView.inputAccountNumber("");
            account = findAccountByNumber(accountNumber);

            if (account == null) {
                OutputView.printErrorMessage("입력하신 계좌 번호는 존재하지 않습니다. 다시 입력해주세요.");
            }
        }

        long money;
        boolean isValidAmount = false;
        while (!isValidAmount) {
            try {
                money = InputView.inputMoney(account.getAmount());
                account.setAmount(money,false);
                OutputView.showWithdrawSuccess(money, account.getAmount());
                isValidAmount = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void accountTransfer() {
        Account myAccount = findAccountByNumber(InputView.inputAccountNumber("출금할 "));
        Account targetAccount = findAccountByNumber(InputView.inputAccountNumber("받는 사람의 "));
        Long money = InputView.transferMoney(targetAccount);
        myAccount.setAmount(money,false);
        targetAccount.setAmount(money,true);
        OutputView.showTransferInformation(myAccount,targetAccount,money);
    }

    private void displayAccount() {
        String registrationNumber = InputView.inputRegistrationNumber();
        User currentUser = customers.findUserByRegistrationNumber(registrationNumber);
        OutputView.showAccountInformation(currentUser);
    }
}
