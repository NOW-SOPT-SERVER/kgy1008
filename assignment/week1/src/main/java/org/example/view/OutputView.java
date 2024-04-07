package org.example.view;

import org.example.domain.BankMenu;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String EXIT_COMMENT = "이용해주셔서 감사합니다.";

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
    public static void showFunction(BankMenu menu){
        System.out.println(menu.getMessage());
    }

    public static void exitSystem() {
        System.out.println(EXIT_COMMENT);
    }

    public static void showAccountResult(boolean flag, String accountHolder, String accountNumber) {
        if (flag) {
            System.out.println(accountHolder + "님의 새 계좌가 성공적으로 추가되었습니다.");
            System.out.println("계좌 번호는 " + accountNumber + "입니다.");
        }
        else{
            System.out.println(accountHolder + "님의 새 계좌가 생성되었습니다.");
            System.out.println("계좌 번호는 " + accountNumber + "입니다.");
        }
    }

    public static void showDepositSuccess(Long money, Long amount) {
        System.out.println("입금액: " + money);
        System.out.println("잔액: " + amount);
    }
}
