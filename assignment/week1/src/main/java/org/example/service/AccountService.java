package org.example.service;

import org.example.domain.Account;
import org.example.domain.UniqueAccountGenerator;
import org.example.domain.User;
import org.example.repository.CustomerRepository;
import org.example.view.InputView;
import org.example.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private CustomerRepository customerRepository;

    public AccountService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createAccount() {
        String accountHolder = InputView.inputName();
        String registrationNumber = InputView.inputRegistrationNumber();
        String accountNumber = UniqueAccountGenerator.generateUniqueAccountNumber();
        Account account = new Account(accountNumber, accountHolder);
        boolean flag = false;

        User existingUser = customerRepository.findUserByRegistrationNumber(registrationNumber);
        if (existingUser != null) {
            flag = true;
            existingUser.getAccounts().add(account);
            OutputView.showAccountResult(flag, accountHolder, accountNumber);
        }
        else {
            List<Account> accounts = new ArrayList<>();
            accounts.add(account);
            User newUser = new User(accountHolder, registrationNumber, accounts);
            customerRepository.addUser(newUser);
            OutputView.showAccountResult(flag, accountHolder, accountNumber);
        }
    }
}
