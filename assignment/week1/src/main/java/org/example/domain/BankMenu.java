package org.example.domain;

public enum BankMenu {
    ONR(1,"계좌 개설", "계좌 개설을 선택하셨습니다."),
    TWO(2,"입금", "예금 입금을 선택하셨습니다."),
    THREE(3,"출금", "예금 출금을 선택하셨습니다."),
    FOUR(4,"계좌 이체", "계좌 이체를 선택하셨습니다."),
    FIVE(5,"계좌 조회", "계좌 조회를 선택하셨습니다."),
    EXIT(6,"종료", "시스템을 종료합니다.");

    private int menuNumber;
    private String function;
    private String message;

    private BankMenu(int menuNumber, String funtion, String message) {
        this.menuNumber = menuNumber;
        this.function = funtion;
        this.message = message;
    }

    public static BankMenu extractFunction(int selectNumber){
        for (BankMenu menu : BankMenu.values()) {
            if (menu.getMenuNumber() == selectNumber) {
                return menu;
            }
        }

        throw new IllegalArgumentException("옳바르지 않은 메뉴 숫자입니다. 다시 입력해주세요.\n");
    }

    public int getMenuNumber(){
        return this.menuNumber;
    }

    public String getMessage(){
        return this.message;
    }

    public String getFunction(){
        return this.function;
    }
}

