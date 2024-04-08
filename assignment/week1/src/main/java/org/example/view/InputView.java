package org.example.view;

import org.example.domain.BankMenu;
import org.example.domain.Account;

import java.util.Scanner;

public class InputView {
    private static final String START = "\n** 은행 시스템 기능 목록 **";
    private static final String INPUT_MENU = "이용하실 메뉴 번호를 입력해주세요. ";
    private static final String INPUT_INFORMATION = "실명정보 확인을 위해 이름과 주민등록번호를 입력하세요. ";
    private static final String INPUT_ACCOUNT = "계좌번호를 입력해주세요. ";
    private static final String INPUT_MONEY = "금액을 입력해주세요. ";

    public static int showBankMenu(){
        System.out.println(START);
        Scanner scanner = new Scanner(System.in);
        for (BankMenu menu : BankMenu.values()) {
            System.out.println(menu.getMenuNumber() + ". " + menu.getFunction());
        }
        System.out.print(INPUT_MENU);
        return scanner.nextInt();
    }

    public static String inputName() {
        System.out.println(INPUT_INFORMATION);
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름: ");
        String name = scanner.nextLine();
        return name;
    }

    public static String inputRegistrationNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("주민번호: ");
        String registrationNumber = scanner.nextLine();
        return registrationNumber;
    }

    public static String inputAccountNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message + INPUT_ACCOUNT);
        return scanner.nextLine();
    }

    public static Long inputMoney(Long money) {
        System.out.println("현재 잔액: " + money);
        Scanner scanner = new Scanner(System.in);
        System.out.print(INPUT_MONEY);
        return scanner.nextLong();
    }

    public static Long transferMoney(Account account){
        System.out.print(account.getAccountHolder() + "님께 이체할 금액을 입력해주세요. ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLong();
    }
}
