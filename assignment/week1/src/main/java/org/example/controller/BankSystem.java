package org.example.controller;

import org.example.view.InputView;
import org.example.view.OutputView;

public class BankSystem {
    public void start(){
        while (true) {
            try {
                int num = InputView.showBankMenu();
                OutputView.showFunction(num);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
