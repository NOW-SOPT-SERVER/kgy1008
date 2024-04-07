package org.example.domain;

import java.util.Random;

public class AccountNumberGenerator {
    private static final int DEFAULT_SIZE = 12;

    public static String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        for (int i=0; i < DEFAULT_SIZE; i++){
            int num = random.nextInt(10);
            accountNumber.append(num);
        }

        return accountNumber.toString();
    }
}
