package org.example.view;

import org.example.repository.Account;
import org.example.domain.BankMenu;
import org.example.repository.User;

import java.util.List;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String EXIT_COMMENT = "이용해주셔서 감사합니다.";

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }

    public static void showFunction(BankMenu menu) {
        System.out.println(menu.getMessage());
    }

    public static void exitSystem() {
        System.out.println(EXIT_COMMENT);
    }

    public static void showAccountResult(boolean flag, String accountHolder, String accountNumber) {
        if (flag) {
            System.out.println(accountHolder + "님의 새 계좌가 성공적으로 추가되었습니다.");
            System.out.println("계좌 번호는 " + accountNumber + "입니다.");
        } else {
            System.out.println(accountHolder + "님의 새 계좌가 생성되었습니다.");
            System.out.println("계좌 번호는 " + accountNumber + "입니다.");
        }
    }

    public static void showDepositSuccess(Long money, Long amount) {
        System.out.println("입금액: " + money);
        System.out.println("잔액: " + amount + "원");
    }

    public static void showWithdrawSuccess(Long money, Long amount) {
        System.out.println("출금액: " + money);
        System.out.println("잔액: " + amount + "원");
    }

    public static void showAccountInformation(User user) {
        System.out.println(user.getName() + "의 계좌 정보는 다음과 같습니다.");
        List<Account> accounts = user.getAccounts();

        if (accounts != null && !accounts.isEmpty()) {
            for (Account account : accounts) {
                System.out.println("계좌 번호: " + account.getAccountNumber());
                System.out.println("잔액: " + account.getAmount() + "원");
            }
        } else {
            System.out.println(user.getName() + "님은 등록된 계좌가 없습니다.");
        }

    }
}
