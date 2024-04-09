package org.example.service;

import org.example.domain.Account;
import org.example.repository.CustomerRepository;
import org.example.view.InputView;
import org.example.view.OutputView;

public class WithdrawService implements IWithdrawService {
    private CustomerRepository customerRepository;
    public WithdrawService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void withdraw() {
        String accountNumber;
        Account account = null;
        while (account == null) {
            accountNumber = InputView.inputAccountNumber("");
            account = customerRepository.findAccountByNumber(accountNumber);

            if (account == null) {
                OutputView.printErrorMessage("입력하신 계좌 번호는 존재하지 않습니다. 다시 입력해주세요.");
            }
        }

        long money;
        boolean isValidAmount = false;
        while (!isValidAmount) {
            try {
                money = InputView.inputMoney(account.getAmount());
                account.setAmount(money,false);
                OutputView.showWithdrawSuccess(money, account.getAmount());
                isValidAmount = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
