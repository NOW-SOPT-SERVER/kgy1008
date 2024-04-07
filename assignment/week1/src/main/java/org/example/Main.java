package org.example;

import org.example.controller.BankSystem;
import org.example.domain.BankMenu;

public class Main {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        while (true) {
            BankMenu menu = bankSystem.executeFunction();
            if (menu == BankMenu.EXIT) break;
        }
    }
}
