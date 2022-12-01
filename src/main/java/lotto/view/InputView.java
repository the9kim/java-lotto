package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readPurchasingMoney() {
        System.out.print("구입 금액을 입력해주세요: ");
        String purchasingMoney = Console.readLine();
        isBlank(purchasingMoney);
        isDigit(purchasingMoney);
        return Integer.parseInt(purchasingMoney);
    }

    private static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다");
        }
    }

    private static void isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값은 입력할 수 없습니다.");
            }
        }
    }
}
