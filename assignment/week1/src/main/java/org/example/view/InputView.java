package org.example.view;

import org.example.domain.BankMenu;

public class InputView {
    private static final String INPUT_MENU = "이용하실 메뉴를 선택해주세요.";

    public static void inputBankMenu(){
        System.out.println(INPUT_MENU);
        for (BankMenu menu : BankMenu.values()) {
            System.out.println(menu.getMenuNumber() + ". " + menu.getMessage());
        }
    }
}
