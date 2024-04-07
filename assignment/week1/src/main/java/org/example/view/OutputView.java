package org.example.view;

import org.example.domain.BankMenu;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
    public static void showFunction(int num){
        BankMenu menu = BankMenu.extractFunction(num);
        System.out.println(menu.getMessage());
    }
}
