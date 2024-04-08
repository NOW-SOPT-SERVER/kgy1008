package org.example.domain;

import org.example.repository.CustomerRepository;

import java.util.*;

public class UniqueAccountGenerator {
    private static final int DEFAULT_SIZE = 12;

    private static String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        for (int i=0; i < DEFAULT_SIZE; i++){
            int num = random.nextInt(10);
            accountNumber.append(num);
        }

        return accountNumber.toString();
    }

    public static String generateUniqueAccountNumber() {
        String accountNumber;
        do {
            accountNumber = UniqueAccountGenerator.generateAccountNumber();
        } while (isAccountNumberExist(accountNumber));
        return accountNumber;
    }

    private static boolean isAccountNumberExist(String accountNumber) {
        CustomerRepository customerRepository = new CustomerRepository();
        List<User> users = customerRepository.getUsers();
        for (User user : users) {
            for (Account account : user.getAccounts()) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    return true;
                }
            }
        }
        return false;
    }
}
