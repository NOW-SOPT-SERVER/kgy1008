package org.example.view;

import org.example.domain.BankMenu;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MENU = "이용하실 메뉴 번호를 입력해주세요.";

    public static int showBankMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_MENU);
        for (BankMenu menu : BankMenu.values()) {
            System.out.println(menu.getMenuNumber() + ". " + menu.getFunction());
        }
        return scanner.nextInt();
    }
}
