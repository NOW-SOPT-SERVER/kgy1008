package org.example.service;

import org.example.domain.Account;
import org.example.repository.CustomerRepository;
import org.example.view.InputView;
import org.example.view.OutputView;

public class TransferService {
    private CustomerRepository customerRepository;

    public TransferService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void accountTransfer() {
        Account myAccount = customerRepository.findAccountByNumber(InputView.inputAccountNumber("출금할 "));
        Account targetAccount = customerRepository.findAccountByNumber(InputView.inputAccountNumber("받는 사람의 "));
        Long money = InputView.transferMoney(targetAccount);
        myAccount.setAmount(money,false);
        targetAccount.setAmount(money,true);
        OutputView.showTransferInformation(myAccount,targetAccount,money);
    }

}
