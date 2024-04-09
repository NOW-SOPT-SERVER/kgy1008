package org.example;

import org.example.controller.BankSystem;
import org.example.domain.BankMenu;
import org.example.service.*;
import org.example.repository.CustomerRepository;

public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = CustomerRepository.getInstance();
        AccountService accountService = new AccountService(customerRepository);
        DepositService depositService = new DepositService(customerRepository);
        WithdrawService withdrawService = new WithdrawService(customerRepository);
        TransferService transferService = new TransferService(customerRepository);
        DisplayService displayService = new DisplayService(customerRepository);

        BankSystem bankSystem = new BankSystem(
                customerRepository,accountService, depositService,
                withdrawService, transferService, displayService);

        while (true) {
            BankMenu menu = bankSystem.executeFunction();
            if (menu == BankMenu.EXIT) break;
        }
    }
}
