package org.example;

import org.example.controller.BankSystem;
import org.example.domain.BankMenu;
import org.example.repository.CustomerRepository;

public class Main {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        while (true) {
            BankMenu menu = bankSystem.executeFunction();
            if (menu == BankMenu.EXIT) break;
        }
    }
}
