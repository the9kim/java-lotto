package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readPurchasingAmount() {
        System.out.println("구입 금액을 입력해주세요");
        String input = Console.readLine();
        isBlank(input);
        isDigit(input);
        return input;
    }

    private static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다");
        }
    }

    private static void isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 정수가 아닙니다.");
            }
        }

    }


}
