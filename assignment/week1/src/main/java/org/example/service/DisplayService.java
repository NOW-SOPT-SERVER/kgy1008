package org.example.service;

import org.example.domain.User;
import org.example.repository.CustomerRepository;
import org.example.view.InputView;
import org.example.view.OutputView;

public class DisplayService implements IDisplayService {
    private CustomerRepository customerRepository;

    public DisplayService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayAccount() {
        String registrationNumber = InputView.inputRegistrationNumber();
        User currentUser = customerRepository.findUserByRegistrationNumber(registrationNumber);
        OutputView.showAccountInformation(currentUser);
    }
}
