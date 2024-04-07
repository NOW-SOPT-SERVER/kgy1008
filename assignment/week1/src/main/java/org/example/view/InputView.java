package org.example.view;

import org.example.domain.BankMenu;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MENU = "이용하실 메뉴 번호를 입력해주세요.";
    private static final String INPUT_INFORMATION = "실명정보 확인을 위해 이름과 주민등록번호를 입력하세요.";

    public static int showBankMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_MENU);
        for (BankMenu menu : BankMenu.values()) {
            System.out.println(menu.getMenuNumber() + ". " + menu.getFunction());
        }
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
}
