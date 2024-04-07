package org.example.domain;

public enum BankMenu {
    ONR(1,"계좌 개설"),
    TWO(2,"입금"),
    THREE(3,"출금"),
    FOUR(4,"계좌 이체"),
    FIVE(5,"계좌 조회"),
    EXIT(6,"종료");

    private int menuNumber;
    private String message;

    private BankMenu(int menuNumber, String message) {
        this.menuNumber = menuNumber;
        this.message = message;
    }

    public static BankMenu extractFunction(int selectNumber){
        for (BankMenu menu : BankMenu.values()) {
            if (menu.getMenuNumber() == selectNumber) {
                return menu;
            }
        }

        throw new IllegalArgumentException("옳바르지 않은 메뉴 숫자입니다.");
    }

    public int getMenuNumber(){
        return this.menuNumber;
    }

    public String getMessage(){
        return this.message;
    }
}

