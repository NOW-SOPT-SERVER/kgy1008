package org.example.controller;

import org.example.domain.BankMenu;
import org.example.domain.User;
import org.example.repository.CustomerRepository;
import org.example.service.AccountService;
import org.example.service.DepositService;
import org.example.service.TransferService;
import org.example.service.WithdrawService;
import org.example.view.InputView;
import org.example.view.OutputView;

public class BankSystem {
    private CustomerRepository customers;
    private AccountService accountService;
    private DepositService depositService;
    private WithdrawService withdrawService;
    private TransferService transferService;

    public BankSystem() {
        this.customers = new CustomerRepository();
        this.accountService = new AccountService(customers);
        this.depositService = new DepositService(customers);
        this.withdrawService = new WithdrawService(customers);
        this.transferService = new TransferService(customers);
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
                accountService.createAccount();
                break;
            case TWO:
                depositService.deposit();
                break;
            case THREE:
                withdrawService.withdraw();
                break;
            case FOUR:
                transferService.accountTransfer();
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

    private void displayAccount() {
        String registrationNumber = InputView.inputRegistrationNumber();
        User currentUser = customers.findUserByRegistrationNumber(registrationNumber);
        OutputView.showAccountInformation(currentUser);
    }
}
