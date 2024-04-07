package org.example.controller;

import org.example.domain.Account;
import org.example.domain.UniqueAccountGenerator;
import org.example.domain.BankMenu;
import org.example.domain.User;
import org.example.view.InputView;
import org.example.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BankSystem {
    private List<User> users;

    public BankSystem() {
        this.users = new ArrayList<>();
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

                break;
            case THREE:

                break;
            case FOUR:

                break;
            case FIVE:

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
        Account account = new Account(accountNumber);
        boolean flag = false;

        User existingUser = findUserByRegistrationNumber(registrationNumber);
        if (existingUser != null) {
            flag = true;
            existingUser.getAccounts().add(account);
            OutputView.showAccountResult(flag, accountHolder, accountNumber);
        }
        else {
            List<Account> accounts = new ArrayList<>();
            accounts.add(account);
            User newUser = new User(accountHolder, registrationNumber, accounts);
            users.add(newUser);
            OutputView.showAccountResult(flag, accountHolder, accountNumber);
        }
    }

    private User findUserByRegistrationNumber(String registrationNumber) {
        for (User user : users) {
            if (user.getRegistrationNumber().equals(registrationNumber)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return this.users;
    }
}
