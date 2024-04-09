package org.example.controller;

import org.example.domain.BankMenu;
import org.example.domain.User;
import org.example.repository.CustomerRepository;
import org.example.service.*;
import org.example.view.InputView;
import org.example.view.OutputView;

public class BankSystem {
    private CustomerRepository customers;
    private AccountService accountService;
    private DepositService depositService;
    private WithdrawService withdrawService;
    private TransferService transferService;
    private DisplayService displayService;

    public BankSystem() {
        this.customers = new CustomerRepository();
        this.accountService = new AccountService(customers);
        this.depositService = new DepositService(customers);
        this.withdrawService = new WithdrawService(customers);
        this.transferService = new TransferService(customers);
        this.displayService = new DisplayService(customers);
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
                displayService.displayAccount();
                break;
            case EXIT:
                OutputView.exitSystem();
                break;
        }
        return menu;
    }
}
